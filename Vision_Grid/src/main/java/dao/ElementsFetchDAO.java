package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ElementBeans;

public class ElementsFetchDAO extends BaseDAO{

	public List<ElementBeans> getElementsByVisionId(int visionId) {
		
		 // 戻り値の準備
        List<ElementBeans> elementsList = new ArrayList<>();
		
		
		try (Connection conn = getConnection()) {
            // SQL文を準備
            String sql = "SELECT * FROM MANDALA_ELEMENTS WHERE VISION_ID = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, visionId);
                try (ResultSet rs = ps.executeQuery()) {
                	while(rs.next()) {
                        // 見つかった場合、ElementBeansを生成して値をセット
                        ElementBeans element = new ElementBeans();
                        element.setElementId(rs.getInt("ELEMENT_ID"));
                        element.setVisionId(rs.getInt("VISION_ID"));
                        element.setPosition(rs.getString("POSITION"));
                        element.setElementKey(rs.getString("ELEMENT_KEY"));
                        element.setElementText(rs.getString("TEXT"));
                        
                        // リストに追加
                        elementsList.add(element);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 要素のリストを返す
        return elementsList;
    }
}                        
