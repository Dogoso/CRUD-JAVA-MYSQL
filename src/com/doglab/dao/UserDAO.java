package com.doglab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.doglab.agenda.User;
import com.doglab.factory.ConectionFactory;
import com.mysql.jdbc.PreparedStatement;

public class UserDAO {

	// CRUD (Create, Read, Update, Delete)
	
	public static void create(User user) {
		String query = "INSERT INTO users(`full name`, `nickname`, `email`, `born`) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(query);
			pstm.setString(1, user.getFullname());
			pstm.setString(2, user.getNickname());
			pstm.setString(3, user.getEmail());
			pstm.setDate(4, new Date(user.getBorn().getTime()));
			pstm.execute();
			System.out.println("Usuário Salvo!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
				System.out.println("Conexões Fechadas!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
