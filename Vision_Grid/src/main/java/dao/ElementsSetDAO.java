package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ElementBeans;

public class ElementsSetDAO extends BaseDAO {

    public List<Integer> setElements(List<ElementBeans> elementsList) {
        // SQLクエリ
        String sql = "INSERT INTO MANDALA_ELEMENTS (VISION_ID, POSITION, ELEMENT_KEY, TEXT) VALUES (?, ?, ?, ?)";

        // 自動生成されたELEMENT_IDを格納するリスト
        List<Integer> elementIdsList = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            for (ElementBeans element : elementsList) {
                // パラメータの設定
                ps.setInt(1, element.getVisionId());
                ps.setString(2, element.getPosition());
                ps.setString(3, element.getElementKey());
                ps.setString(4, element.getElementText());

                // SQL実行
                ps.executeUpdate();

                // 自動生成されたキーを取得
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int elementId = rs.getInt(1); // 生成されたELEMENT_IDを取得
                        elementIdsList.add(elementId);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // エラーを出力
        }

        // 自動生成されたキーのリストを返却
        return elementIdsList;
    }
}
