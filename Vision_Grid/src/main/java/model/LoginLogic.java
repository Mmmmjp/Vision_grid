package model;

import dao.AccountsDAO;

public class LoginLogic {
	
	public AccountBeans execute(AccountBeans authAccount) {
		AccountsDAO dao = new AccountsDAO();
		AccountBeans foundAccount = dao.findAccount(authAccount);
		
		return foundAccount;
	}
}