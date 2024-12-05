package model;

import dao.AccountsDAO;

public class LoginLogic {
	
	public AccountBeans execute(AccountBeans account) {
		AccountsDAO dao = new AccountsDAO();
		AccountBeans foundAccount = dao.findAccount(account);
		
		return foundAccount;
	}
}