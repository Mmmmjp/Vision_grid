package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.VisionBeans;

public class VisionFetchDAO extends BaseDAO {
	
    public VisionBeans getVisionByUserId(int userId) {
        
    	VisionBeans vision = null; // 初期値はnull

        try (Connection conn = getConnection()) {
            // SQL文を準備
            String sql = "SELECT * FROM MANDALA_VISION WHERE USER_ID = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // 見つかった場合、VisionBeansを生成して値をセット
                        vision = new VisionBeans();
                        vision.setVisionId(rs.getInt("VISION_ID"));
                        vision.setUserId(rs.getInt("USER_ID"));
                        vision.setVisionKey(rs.getString("VISION_KEY"));
                        vision.setVisionText(rs.getString("TEXT"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching Vision by userId: " + e.getMessage());
            e.printStackTrace();
        }

        return vision; // 見つからなければnull
    }
}

