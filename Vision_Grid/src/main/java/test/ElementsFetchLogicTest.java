package test;

import java.util.List;

import model.ElementBeans;
import model.ElementsFetchLogic;

public class ElementsFetchLogicTest {

    public static void main(String[] args) {
        ElementsFetchLogicTest test = new ElementsFetchLogicTest();
        test.testGetElementsByVisionId();
        test.testGetElementsByVisionId_NoData();
    }

    /**
     * 正常系テスト: 指定したvisionIdに対応する要素が存在する場合
     */
    public void testGetElementsByVisionId() {
        ElementsFetchLogic logic = new ElementsFetchLogic();
        int testVisionId = 1; // テスト用のvisionId
        List<ElementBeans> elementsList = logic.getElementsByVisionId(testVisionId);

        if (elementsList != null && !elementsList.isEmpty()) {
            System.out.println("testGetElementsByVisionId: 成功★");
            for (ElementBeans element : elementsList) {
                System.out.println("Element ID: " + element.getElementId());
                System.out.println("Position: " + element.getPosition());
                System.out.println("Element Key: " + element.getElementKey());
                System.out.println("Text: " + element.getElementText());
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("testGetElementsByVisionId: 失敗 - データが見つかりません");
        }
    }

    /**
     * 異常系テスト: 指定したvisionIdに対応する要素が存在しない場合
     */
    public void testGetElementsByVisionId_NoData() {
        ElementsFetchLogic logic = new ElementsFetchLogic();
        int testVisionId = 99999; // 存在しないvisionId
        List<ElementBeans> elementsList = logic.getElementsByVisionId(testVisionId);

        if (elementsList == null || elementsList.isEmpty()) {
            System.out.println("testGetElementsByVisionId_NoData: 成功★ - データが見つかりませんでした");
        } else {
            System.out.println("testGetElementsByVisionId_NoData: 失敗 - データが存在するはずがありません");
        }
    }
}

