package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountsDAO extends BaseDAO {

    // ログインアカウントを探す
    public AccountBeans findAccount(AccountBeans authAccount) {
        // 戻り値の用意(インスタンスの生成)
        AccountBeans foundAccount = new AccountBeans();

        // データベースへ接続
        try (Connection conn = getConnection()) {
            // SQL文を準備
            String sql = "SELECT * FROM USERS WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, authAccount.getUserName());
            ps.setString(2, authAccount.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // 見つかったアカウント情報を戻り値にセット
                foundAccount.setUserId(rs.getInt("USER_ID"));
                foundAccount.setUserName(rs.getString("USERNAME"));
                foundAccount.setRealName(rs.getString("REAL_NAME"));
                foundAccount.setPassword(rs.getString("PASSWORD"));
                foundAccount.setDob(rs.getDate("DOB").toLocalDate());
                foundAccount.setGender(rs.getString("GENDER"));
            } else {
                // アカウントがなければ null を返す
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return foundAccount;
    }
}

