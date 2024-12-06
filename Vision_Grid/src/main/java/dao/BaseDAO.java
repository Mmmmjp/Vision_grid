package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {

    // データベース接続情報
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Documents/database/VisionGrid";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    // データベース接続を取得するメソッド
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }

    // JDBCドライバの読み込み 
    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバの読み込みに失敗しました", e);
        }
    }
}

