package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.PostMutterBeans;

public class MuttersSetDAO extends BaseDAO{
	
    /**
     * 投稿を保存するDAO
     * 
     * @param mutter 保存する投稿データ
     * @return 成功すればtrue、失敗すればfalse
     */

	public boolean createPost(PostMutterBeans mutter) {
		 // SQLクエリ
        String sql = "INSERT INTO HUB_POSTS (USER_ID, POST_DATE , POST_TEXT) VALUES (?, ?, ?)";
        
        boolean result = false;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // パラメータの設定
            ps.setInt(1, mutter.getUserId());
            ps.setTimestamp(2, mutter.getPostDate());
            ps.setString(3, mutter.getPostText());

            // 実行
            int rowsAffected = ps.executeUpdate();
            result = rowsAffected == 1; // 更新された行が1件なら成功

        } catch (SQLException e) {
            e.printStackTrace(); // エラーをログに出力
        }

        return result;
    }
}