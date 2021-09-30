package com.doglab.application;

import com.doglab.agenda.User;
import com.doglab.dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		
		User user = UserDAO.read(2);
		user.setFullname("Silas Juan Santos Lago");
		user.setEmail("juanfsa@live.com");
		user.setNickname("Dogoso");
		UserDAO.update(user);
		
	}

}
