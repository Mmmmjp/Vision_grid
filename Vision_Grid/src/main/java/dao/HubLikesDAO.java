package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PostLikesBeans;

public class HubLikesDAO extends BaseDAO {

    /**
     * いいねを追加するDAO
     * 
     * @param like いいね情報を含むPostLikesBeans
     * @return 成功すればtrue、失敗すればfalse
     */
    public boolean addLikes(PostLikesBeans like) {
        // 重複チェッククエリ
        String checkSql = "SELECT COUNT(*) FROM HUB_LIKES WHERE MUTTER_ID = ? AND USER_ID = ?";
        // INSERTクエリ
        String insertSql = "INSERT INTO HUB_LIKES (MUTTER_ID, USER_ID) VALUES (?, ?)";

        try (Connection con = getConnection();
             PreparedStatement checkPs = con.prepareStatement(checkSql);
             PreparedStatement insertPs = con.prepareStatement(insertSql)) {

            // 重複チェック
            checkPs.setInt(1, like.getPostId());
            checkPs.setInt(2, like.getUserId());
            ResultSet rs = checkPs.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // レコードが既に存在している場合
                System.out.println("すでにいいね済みです。");
                return false; // 重複があれば挿入を行わない
            }

            // 新しいレコードを挿入
            insertPs.setInt(1, like.getPostId());
            insertPs.setInt(2, like.getUserId());
            int rowsAffected = insertPs.executeUpdate();
            return rowsAffected == 1; // 成功時はtrue

        } catch (SQLException e) {
            e.printStackTrace(); // エラーをログに出力
            return false; // エラー時はfalseを返す
        }
    }
}
