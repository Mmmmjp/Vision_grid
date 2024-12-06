package model;

import java.sql.SQLException;

import dao.AccountRegisterDAO;

public class RegisterLogic {

	public void execute(AccountBeans pendingAccount) throws SQLException {
	    AccountRegisterDAO dao = new AccountRegisterDAO();
	    dao.createAccount(pendingAccount);
	}
}