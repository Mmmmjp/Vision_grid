package model;

import java.io.Serializable;
import java.time.LocalDate;

public class AccountBeans implements Serializable{

	
	private int userId;
	private String userName;
	private String password;
	private String realName;
	private LocalDate dob;
	private String gender;
	
	//Constructors 
	
	public AccountBeans() {}
	
	public AccountBeans(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}
	
	public AccountBeans(int userId,String userName, String password, String realName,LocalDate dob, String gender) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.dob = dob;
		this.gender = gender;
		
	}

	// Getter and setter 
	public int getUserId() {
		return userId;
		}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		
	    return "AccountBeans [userId=" + userId + ", userName=" + userName + ", realName=" + realName
	            + ", dob=" + dob + ", gender=" + gender + "]";
	}
}
