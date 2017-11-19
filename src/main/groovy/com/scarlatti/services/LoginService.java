package com.scarlatti.services;

import com.scarlatti.model.LoginFlowBean;
import org.springframework.stereotype.Component;

@Component("loginService")
public class LoginService
{
	public String validateUser(LoginFlowBean loginFlowBean) {
		String userName = loginFlowBean.getUserName();
		String password = loginFlowBean.getPassword();
		return String.valueOf(userName.equals("admin") && password.equals("admin"));
	}
}
