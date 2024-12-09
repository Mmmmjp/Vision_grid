package test;

import dao.VisionFetchDAO;
import model.VisionBeans;

public class VisionFetchDAOTest {
    public static void main(String[] args) {
        VisionFetchDAOTest test = new VisionFetchDAOTest();
        test.testGetVisionByUserId();
        test.testGetVisionByUserId_NoData();
    }

    public void testGetVisionByUserId() {
        // Arrange
        int testUserId = 1; // テストデータ miwa_test に対応
        String expectedVisionKey = "目標_テスト";
        String expectedVisionText = "これはテスト用の目標です";

        VisionFetchDAO dao = new VisionFetchDAO();

        // Act
        VisionBeans result = dao.getVisionByUserId(testUserId);

        // Assert
        if (result != null
                && expectedVisionKey.equals(result.getVisionKey())
                && expectedVisionText.equals(result.getVisionText())
                && result.getUserId() == testUserId) {
            System.out.println("testGetVisionByUserId: 成功★");
        } else {
            System.out.println("testGetVisionByUserId: 失敗");
            if (result != null) {
                System.out.println("Returned Vision: " + result);
            } else {
                System.out.println("Returned Vision is null");
            }
        }
    }

    public void testGetVisionByUserId_NoData() {
        // Arrange
        int nonExistentUserId = 9999; // 存在しないユーザID
        VisionFetchDAO dao = new VisionFetchDAO();

        // Act
        VisionBeans result = dao.getVisionByUserId(nonExistentUserId);

        // Assert
        if (result == null) {
            System.out.println("testGetVisionByUserId_NoData: 成功★");
        } else {
            System.out.println("testGetVisionByUserId_NoData: 失敗");
            System.out.println("Returned Vision: " + result);
        }
    }
}

