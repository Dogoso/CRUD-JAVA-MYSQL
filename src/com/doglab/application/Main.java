package com.doglab.application;

import java.util.Date;

import com.doglab.agenda.User;
import com.doglab.dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.setFullname("Joao Pedro de Morais");
		user.setNickname("JoaoZINdaPeixeira");
		user.setEmail("joaopm@outlook.com");
		user.setBorn(new Date());
		UserDAO.create(user);
	}

}
