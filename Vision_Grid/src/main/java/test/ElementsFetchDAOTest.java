package test;

import java.util.List;

import dao.ElementsFetchDAO;
import model.ElementBeans;

public class ElementsFetchDAOTest {

	public static void main(String[] args) {
	    testGetElementsByVisionId();
        testGetElementsByVisionId_NoData();
    }
	
	public static void testGetElementsByVisionId() {
        System.out.println("Running testGetElementsByVisionId...");

        // テスト用のVision ID
        int visionId = 1;

        ElementsFetchDAO dao = new ElementsFetchDAO();
        List<ElementBeans> elementsList = dao.getElementsByVisionId(visionId);

        // テスト結果を表示
        if (elementsList != null && elementsList.size() > 0) {
            System.out.println("見つかった要素数: " + elementsList.size());
            for (ElementBeans element : elementsList) {
                System.out.println("Element ID: " + element.getElementId());
                System.out.println("Vision ID: " + element.getVisionId());
                System.out.println("Position: " + element.getPosition());
                System.out.println("Element Key: " + element.getElementKey());
                System.out.println("Text: " + element.getElementText());
                System.out.println("-----------------------");
            }
            System.out.println("testGetElementsByVisionId: 成功★");
        } else {
            System.out.println("testGetElementsByVisionId: 失敗");
        }
    }

    public static void testGetElementsByVisionId_NoData() {
        System.out.println("Running testGetElementsByVisionId_NoData...");

        // 存在しないVision IDを指定
        int visionId = 99999;

        // DAOインスタンスを生成
        ElementsFetchDAO dao = new ElementsFetchDAO();

        // メソッドを呼び出し
        List<ElementBeans> elementsList = dao.getElementsByVisionId(visionId);

        // テスト結果を表示
        if (elementsList == null || elementsList.size() == 0) {
            System.out.println("testGetElementsByVisionId_NoData: 成功★");
        } else {
            System.out.println("testGetElementsByVisionId_NoData: 失敗");
        }
    }
}


