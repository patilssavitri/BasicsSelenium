package com.sdet;

import java.util.ResourceBundle;

public class App {
	
	public int userLogin(String in_User, String in_pwd)
	{
		ResourceBundle rb= ResourceBundle.getBundle("config");
		String userName=rb.getString("username");
		String password=rb.getString("password");
		if(in_User.equals(userName) && in_pwd.equals(password))
			return 1;
		else
			return 0;
		
	}

}
