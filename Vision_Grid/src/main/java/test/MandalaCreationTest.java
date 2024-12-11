package test;

import dao.VisionSetDAO;
import model.VisionBeans;

public class MandalaCreationTest {

    public static void main(String[] args) {
        System.out.println("==== Mandala Creation Tests ====");
        testVisionCreation();
    }

    /**
     * VisionSetDAOのsetVisionメソッドのテスト
     */
    public static void testVisionCreation() {
        System.out.println("[Test: Vision Creation]");

        // テスト用データを作成
        VisionBeans vision = new VisionBeans();
        vision.setUserId(33); // test1ユーザーのUSER_ID
        vision.setVisionKey("Test Vision Key");
        vision.setVisionText("This is a test vision text.");

        // DAOのインスタンスを作成してメソッドを呼び出し
        VisionSetDAO dao = new VisionSetDAO();
        int generatedId = dao.setVision(vision);

        // 結果をコンソールに出力
        if (generatedId > 0) {
            System.out.println("SUCCESS: Vision created successfully. Generated VISION_ID: " + generatedId);
        } else {
            System.out.println("FAILURE: Vision creation failed.");
        }
    }
}

