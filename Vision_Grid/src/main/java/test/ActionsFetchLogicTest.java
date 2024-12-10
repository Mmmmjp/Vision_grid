package test;

import java.util.ArrayList;
import java.util.List;

import model.ActionBeans;
import model.ActionsFetchLogic;

public class ActionsFetchLogicTest {

    public static void main(String[] args) {
        // テスト用データ準備
        List<Integer> elementIdsList = new ArrayList<>();
        elementIdsList.add(1); // e1
        elementIdsList.add(2); // e2

        // ActionsFetchLogic のインスタンスを作成
        ActionsFetchLogic logic = new ActionsFetchLogic();

        // メソッドを呼び出し
        List<ActionBeans> actionsList = logic.getActionsByElementIds(elementIdsList);

        // 結果を表示
        if (actionsList != null && !actionsList.isEmpty()) {
            System.out.println("testGetActionsByElementIds: 成功★");
            for (ActionBeans action : actionsList) {
                System.out.println("Action ID: " + action.getActionId());
                System.out.println("Element ID: " + action.getElementId());
                System.out.println("Position: " + action.getPosition());
                System.out.println("Action Key: " + action.getActionKey());
                System.out.println("Text: " + action.getActionText());
                System.out.println("-------------");
            }
        } else {
            System.out.println("testGetActionsByElementIds: 失敗");
        }
    }
}

