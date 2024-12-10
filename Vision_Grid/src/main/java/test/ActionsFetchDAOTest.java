package test;

import java.util.ArrayList;
import java.util.List;

import dao.ActionsFetchDAO;
import model.ActionBeans;

public class ActionsFetchDAOTest {
    public static void main(String[] args) {
        // テスト用のデータ準備
        List<Integer> testElementIds = new ArrayList<>();
        testElementIds.add(1);
        testElementIds.add(2);
        testElementIds.add(3);

        // DAOのインスタンス作成
        ActionsFetchDAO dao = new ActionsFetchDAO();

        // テスト開始
        System.out.println("===== ActionsFetchDAO Test =====");
        try {
            // アクションデータ取得
            List<ActionBeans> actionsList = dao.getActionsByElementIds(testElementIds);

            // 結果をコンソールに表示
            if (actionsList.isEmpty()) {
                System.out.println("No actions found for the given element IDs.");
            } else {
                System.out.println("Actions fetched successfully:");
                for (ActionBeans action : actionsList) {
                    System.out.println("Action ID: " + action.getActionId());
                    System.out.println("Element ID: " + action.getElementId());
                    System.out.println("Position: " + action.getPosition());
                    System.out.println("Action Key: " + action.getActionKey());
                    System.out.println("Text: " + action.getActionText());
                    System.out.println("-------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching actions: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

