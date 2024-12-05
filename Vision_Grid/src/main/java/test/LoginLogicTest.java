package test;

import model.AccountBeans;
import model.LoginLogic;

public class LoginLogicTest {

	public static void main(String[] args) {
		
		testExcecuteOK(); //ログイン成功のテスト
		testExcecuteNG(); //ログイン失敗のテスト
	}
	
	public static void testExcecuteOK() {
		AccountBeans account = new AccountBeans("miwa_test","1234");
		LoginLogic bo = new LoginLogic();
		AccountBeans foundAccount = bo.execute(account);
		
		if(foundAccount != null) {
			System.out.println("testExceuteOK:成功★");
		} else {
			System.out.println("testExceuteOK:失敗");
		}
	}
	
	
	public static void testExcecuteNG() {
		AccountBeans account = new AccountBeans("miwa_test","12345");
		LoginLogic bo = new LoginLogic();
		AccountBeans foundAccount= bo.execute(account);
		
		if (foundAccount == null) {
			System.out.println("testExceuteNG:成功★");
		} else {
			System.out.println("testExceuteNG:失敗");
		}
	}	
}

