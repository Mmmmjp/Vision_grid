package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.VisionBeans;

public class VisionSetDAO extends BaseDAO {

    public int setVision(VisionBeans vision) {
        // SQLクエリ
        String sql = "INSERT INTO MANDALA_VISION (USER_ID, VISION_KEY, TEXT) VALUES (?, ?, ?)";
        int visionId = 0;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // パラメータの設定
            ps.setInt(1, vision.getUserId());
            ps.setString(2, vision.getVisionKey());
            ps.setString(3, vision.getVisionText());

            // 実行
            ps.executeUpdate();

            // 自動生成されたキーを取得
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    visionId = rs.getInt(1); // 生成されたVISION_IDを取得
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return visionId; // 生成されたVISION_IDを返す
    }
}

