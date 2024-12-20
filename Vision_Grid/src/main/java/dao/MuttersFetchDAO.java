package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.PostMutterBeans;

public class MuttersFetchDAO extends BaseDAO {

    public List<PostMutterBeans> getAllMutters() {
        List<PostMutterBeans> mutterList = new ArrayList<>();

        // 修正済みSQL: 正しい列名に更新
        String sql = "SELECT HUB_POSTS.POST_ID, HUB_POSTS.USER_ID, USERS.USERNAME, HUB_POSTS.POST_DATE, HUB_POSTS.POST_TEXT, " +
                     "       (SELECT COUNT(*) FROM HUB_LIKES WHERE HUB_LIKES.MUTTER_ID = HUB_POSTS.POST_ID) AS LIKE_COUNT " +
                     "FROM HUB_POSTS " +
                     "INNER JOIN USERS ON HUB_POSTS.USER_ID = USERS.USER_ID " +
                     "ORDER BY HUB_POSTS.POST_DATE DESC";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int postId = rs.getInt("POST_ID");
                int userId = rs.getInt("USER_ID");
                String userName = rs.getString("USERNAME"); // 修正済み
                Timestamp postDate = rs.getTimestamp("POST_DATE");
                String postText = rs.getString("POST_TEXT");
                int likeCount = rs.getInt("LIKE_COUNT");

                // PostMutterBeans オブジェクトにデータを設定
                PostMutterBeans mutter = new PostMutterBeans(postId, userId, userName, postDate, postText);
                mutter.setLikeCount(likeCount);

                mutterList.add(mutter);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mutterList;
    }
}
