package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountsDAO {

	//データベースに接続する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Documents/database/VisionGrid";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	//ログインアカウントを探す
		public AccountBeans findAccount(AccountBeans account) {
			
			//戻り値の用意(Instanseの生成）
			AccountBeans foundAccount = new AccountBeans();
			
			//JDBCドライバを読み込む
			try {
				Class.forName("org.h2.Driver");
			}catch(ClassNotFoundException e) {
				throw new IllegalStateException
				("JDBCを読み込めませんでした");
			}
			
			//データベースへ接続
			try (Connection conn = DriverManager.getConnection(
					JDBC_URL,DB_USER,DB_PASS)){
				
				//SQL文を準備
				String sql = "SELECT * FROM USERS WHERE username = ? AND password = ?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,account.getUserName());
				ps.setString(2, account.getPassword());
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					//見つかったアカウント情報を戻り値にセット
					foundAccount.setUserId(rs.getInt("USER_ID"));
					foundAccount.setUserName(rs.getString("USERNAME"));
					foundAccount.setRealName(rs.getString("REAL_NAME"));
					foundAccount.setPassword(rs.getString("PASSWORD"));
					foundAccount.setDob(rs.getDate("DOB").toLocalDate());
					foundAccount.setGender(rs.getString("GENDER"));	
					
				} else {
					//アカウントがなければnullを返す
					return null;
				}
			} catch (SQLException e) {
					e.printStackTrace();
					return null;
			}
				return foundAccount;
				
		}
}
