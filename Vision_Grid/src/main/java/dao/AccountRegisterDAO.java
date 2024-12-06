package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountRegisterDAO extends BaseDAO {

	public void createAccount(AccountBeans pendingAccount) throws SQLException {
	    String sql = "INSERT INTO USERS (USERNAME, REAL_NAME, PASSWORD, DOB, GENDER) VALUES (?, ?, ?, ?, ?)";

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        java.sql.Date sqlDob = java.sql.Date.valueOf(pendingAccount.getDob());
	        ps.setString(1, pendingAccount.getUserName());
	        ps.setString(2, pendingAccount.getRealName());
	        ps.setString(3, pendingAccount.getPassword());
	        ps.setDate(4, sqlDob);
	        ps.setString(5, pendingAccount.getGender());

	        int result = ps.executeUpdate();
	        if (result == 0) {
	            throw new RuntimeException("アカウントの登録に失敗しました。");
	        }
	    } catch (SQLException e) {
	        // SQLState またはメッセージ内容で一意制約違反を判定
	        if ("23000".equals(e.getSQLState()) || e.getMessage().contains("Unique index or primary key violation")) {
	            throw new IllegalArgumentException("このユーザー名は既に使用されています。", e);
	        }
	        throw e; // その他の例外はそのままスロー
	    }
	}

}

