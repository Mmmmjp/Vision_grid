package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.PostMutterBeans;

public class MuttersFetchDAO extends BaseDAO {

    /**
     * 全てのつぶやきを取り出すメソッド
     * 
     * @return つぶやき全てをBEANSに格納しリストで返す
     */
    public List<PostMutterBeans> getAllMutters() {
        List<PostMutterBeans> mutterList = new ArrayList<>();

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
                String userName = rs.getString("USERNAME");
                Timestamp postDate = rs.getTimestamp("POST_DATE");
                String postText = rs.getString("POST_TEXT");
                int likeCount = rs.getInt("LIKE_COUNT");

                PostMutterBeans mutter = new PostMutterBeans(postId, userId, userName, postDate, postText);
                mutter.setLikeCount(likeCount);

                mutterList.add(mutter);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mutterList;
    }

   
    /**
     * 年と月別に投稿を取得するメソッド
     *
     * @return 年をキーにし、さらにその年の月をキーにした投稿リストを返すマップ
     */
    public Map<String, Map<String, List<PostMutterBeans>>> getMuttersGroupedByYearAndMonth() {
        Map<String, Map<String, List<PostMutterBeans>>> muttersByYearAndMonth = new HashMap<>();

        // SQL文：H2データベースに適した日付フォーマットを使用
        String sql = "SELECT " +
                     "    FORMATDATETIME(HUB_POSTS.POST_DATE, 'yyyy') AS POST_YEAR, " +
                     "    FORMATDATETIME(HUB_POSTS.POST_DATE, 'MM') AS POST_MONTH, " +
                     "    HUB_POSTS.POST_ID, HUB_POSTS.USER_ID, USERS.USERNAME, HUB_POSTS.POST_DATE, HUB_POSTS.POST_TEXT, " +
                     "    (SELECT COUNT(*) FROM HUB_LIKES WHERE HUB_LIKES.MUTTER_ID = HUB_POSTS.POST_ID) AS LIKE_COUNT " +
                     "FROM HUB_POSTS " +
                     "INNER JOIN USERS ON HUB_POSTS.USER_ID = USERS.USER_ID " +
                     "ORDER BY HUB_POSTS.POST_DATE DESC";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String postYear = rs.getString("POST_YEAR"); // 年 (例: 2024)
                String postMonth = rs.getString("POST_MONTH"); // 月 (例: 12)
                int postId = rs.getInt("POST_ID");
                int userId = rs.getInt("USER_ID");
                String userName = rs.getString("USERNAME");
                Timestamp postDate = rs.getTimestamp("POST_DATE");
                String postText = rs.getString("POST_TEXT");
                int likeCount = rs.getInt("LIKE_COUNT");

                // PostMutterBeans オブジェクトにデータを設定
                PostMutterBeans mutter = new PostMutterBeans(postId, userId, userName, postDate, postText);
                mutter.setLikeCount(likeCount);

                // 年ごとのマップを取得または作成
                muttersByYearAndMonth
                    .computeIfAbsent(postYear, k -> new HashMap<>())
                    .computeIfAbsent(postMonth, k -> new ArrayList<>())
                    .add(mutter);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return muttersByYearAndMonth;
    }
}
