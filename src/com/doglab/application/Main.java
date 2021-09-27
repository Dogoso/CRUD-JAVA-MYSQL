package com.doglab.application;

import java.util.Date;
import java.util.List;

import com.doglab.agenda.User;
import com.doglab.dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		List<User> users = UserDAO.read();
		for(User u : users) {
			System.out.println(u.getId()+" | "+u.getFullname());
		}
	}

}
