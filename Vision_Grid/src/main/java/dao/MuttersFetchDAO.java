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
        // 戻り値のリスト
        List<PostMutterBeans> muttersList = new ArrayList<>();

        // 修正版SQLクエリ
        String sql = "SELECT HUB_POSTS.POST_ID, HUB_POSTS.USER_ID, USERS.USERNAME, HUB_POSTS.POST_DATE, HUB_POSTS.POST_TEXT " +
                     "FROM HUB_POSTS " +
                     "INNER JOIN USERS ON HUB_POSTS.USER_ID = USERS.USER_ID " +
                     "ORDER BY HUB_POSTS.POST_DATE DESC";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // クエリを実行
            ResultSet rs = ps.executeQuery();

            // 結果をリストに格納
            while (rs.next()) {
                int postId = rs.getInt("POST_ID");
                int userId = rs.getInt("USER_ID");
                String username = rs.getString("USERNAME");
                Timestamp postDate = rs.getTimestamp("POST_DATE");
                String postText = rs.getString("POST_TEXT");

                // PostMutterBeansオブジェクトを作成し、リストに追加
                PostMutterBeans mutter = new PostMutterBeans(postId, userId, username, postDate, postText);
                muttersList.add(mutter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return muttersList;
    }
}
