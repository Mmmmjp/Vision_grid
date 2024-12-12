package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.ActionBeans;

public class ActionsSetDAO extends BaseDAO {

    public boolean setActions(List<ActionBeans> actionsList) {
        // Skip ACTION_ID since it's auto-increment
        String sql = "INSERT INTO MANDALA_ACTIONS (ELEMENT_ID, POSITION, ACTION_KEY, TEXT) VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection(); // コネクションの取得
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (ActionBeans action : actionsList) {
                // パラメータの設定
                ps.setInt(1, action.getElementId());
                ps.setString(2, action.getPosition());
                ps.setString(3, action.getActionKey());
                ps.setString(4, action.getActionText());
                ps.addBatch(); // バッチに追加
            }

            ps.executeBatch(); // バッチ処理を実行
            System.out.println("すべてのアクションが正常に保存されました。");
            return true;

        } catch (Exception e) {
            e.printStackTrace(); // エラー内容を出力
            return false;
        }
    }
}
