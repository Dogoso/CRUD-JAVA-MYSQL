package com.doglab.application;

import java.util.List;

import com.doglab.agenda.User;
import com.doglab.dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		
		UserDAO.update("full name", "Silas Juan Santos Lago", 2);
		
		User u = UserDAO.read(2);
		System.out.println("Usuário: "+u.getFullname());
		System.out.println("ID: "+u.getId());
		System.out.println("Email: "+u.getEmail());
		System.out.println("Apelido: "+u.getNickname());
		System.out.println("Data de Nascimento: "+u.getBorn());
		
		/*
		for(User us : UserDAO.read()) {
			System.out.println("---------------------------");
			System.out.println("Usuário: "+us.getFullname());
			System.out.println("ID: "+us.getId());
			System.out.println("Email: "+us.getEmail());
			System.out.println("Apelido: "+us.getNickname());
			System.out.println("Data de Nascimento: "+us.getBorn());
		}
		*/
	}

}
