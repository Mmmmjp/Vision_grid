package test;

import java.time.LocalDate;

import dao.AccountsDAO;
import model.AccountBeans;

public class AccountsDAOTest {

    public static void main(String[] args) {
        testFindAccountOK();
        testFindAccountNG();
    }

    public static void testFindAccountOK() {
        AccountBeans account = new AccountBeans("miwa_test", "1234");
        AccountsDAO dao = new AccountsDAO();

        AccountBeans result = dao.findAccount(account);

        if (result != null &&
            result.getUserId() == 1 &&
            result.getUserName().equals("miwa_test") &&
            result.getRealName().equals("美和 テスト") &&
            result.getPassword().equals("1234") &&
            result.getDob().equals(LocalDate.parse("2024-05-25")) && // 修正
            result.getGender().equals("秘密")) {
            
            System.out.println("testFindAccountOK:成功★");
        } else {
            System.out.println("testFindAccountOK:失敗。");
        }
    }
    
    public static void testFindAccountNG() {
        AccountBeans account = new AccountBeans("miwa_test", "12345");
        AccountsDAO dao = new AccountsDAO();

        AccountBeans result = dao.findAccount(account);

        if (result == null) {
            
            System.out.println("testFindAccountNG:成功★");
        } else {
            System.out.println("testFindAccountNG:失敗。");
        }
    }
}
