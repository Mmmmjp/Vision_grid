package test;

import model.VisionBeans;
import model.VisionFetchLogic;

public class VisionFetchLogicTest {

    public static void main(String[] args) {
        testGetVisionByUserId(); // 正常系のテスト
        testGetVisionByUserId_NoData(); // データが存在しない場合のテスト
    }

    public static void testGetVisionByUserId() {
        VisionFetchLogic logic = new VisionFetchLogic();
        int testUserId = 1; // テスト用のユーザーID

        try {
            VisionBeans vision = logic.getVisionByUserId(testUserId);
            if (vision != null && vision.getUserId() == testUserId) {
                System.out.println("testGetVisionByUserId: 成功★");
                System.out.println("Returned Vision: " + vision.getVisionKey());
            } else {
                System.out.println("testGetVisionByUserId: 失敗");
            }
        } catch (Exception e) {
            System.out.println("testGetVisionByUserId: 失敗");
            e.printStackTrace();
        }
    }

    public static void testGetVisionByUserId_NoData() {
        VisionFetchLogic logic = new VisionFetchLogic();
        int testUserId = 999; // 存在しないユーザーID

        try {
            VisionBeans vision = logic.getVisionByUserId(testUserId);
            if (vision == null) {
                System.out.println("testGetVisionByUserId_NoData: 成功★");
            } else {
                System.out.println("testGetVisionByUserId_NoData: 失敗");
            }
        } catch (Exception e) {
            System.out.println("testGetVisionByUserId_NoData: 失敗");
            e.printStackTrace();
        }
    }
}
