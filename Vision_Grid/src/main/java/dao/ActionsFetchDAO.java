package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ActionBeans;

public class ActionsFetchDAO extends BaseDAO {

    public List<ActionBeans> getActionsByElementIds(List<Integer> elementIds) {
        // 戻り値の準備
        List<ActionBeans> actionsList = new ArrayList<>();

        // SQLクエリを動的に作成
        StringBuilder sql = new StringBuilder("SELECT * FROM MANDALA_ACTIONS WHERE ELEMENT_ID IN (");
        for (int i = 0; i < elementIds.size(); i++) {
            sql.append("?");
            if (i < elementIds.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            // プレースホルダーに値をセット
            for (int i = 0; i < elementIds.size(); i++) {
                ps.setInt(i + 1, elementIds.get(i));
            }

            // クエリ実行
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // アクションのデータを取得してリストに追加
                    ActionBeans action = new ActionBeans();
                    action.setActionId(rs.getInt("ACTION_ID"));
                    action.setElementId(rs.getInt("ELEMENT_ID"));
                    action.setPosition(rs.getString("POSITION"));
                    action.setActionKey(rs.getString("ACTION_KEY"));
                    action.setActionText(rs.getString("TEXT"));

                    actionsList.add(action);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // アクションリストを返す
        return actionsList;
    }
}
