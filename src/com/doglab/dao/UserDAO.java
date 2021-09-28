package com.doglab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doglab.agenda.User;
import com.doglab.factory.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;

public class UserDAO {

	// CRUD (Create, Read, Update, Delete)
	
	public static void create(User user) {
		String query = "INSERT INTO users(`full name`, `nickname`, `email`, `born`) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
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

	public static List<User> read() {
		String query = "SELECT * FROM users";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<User> users = new ArrayList<User>();
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(query);
			rset = pstm.executeQuery();
			while(rset.next()) {
				User user = new User();
				user.setId(rset.getInt("id"));
				user.setFullname(rset.getString("full name"));
				user.setNickname(rset.getString("nickname"));
				user.setEmail(rset.getString("email"));
				user.setBorn(rset.getDate("born"));
				users.add(user);
			}
			System.out.println("Select Completo!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(rset!=null) {
					rset.close();
				}
				System.out.println("Conexão Fechada!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public static User read(int id) {
		String query = "SELECT * FROM users WHERE id = "+id;
		User user = new User();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(query);
			rset = pstm.executeQuery();
			rset.next();
			user.setFullname(rset.getString(2));
			user.setId(rset.getInt(1));
			user.setNickname(rset.getString(3));
			user.setEmail(rset.getString(4));
			user.setBorn(rset.getDate(5));
			
			System.out.println("Select Completo!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(rset!=null) {
					rset.close();
				}
				System.out.println("Conexão Fechada!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public static void update(String set, String id) {
		String query = "UPDATE users SET "+set+" WHERE id = "+id;
		
	}
	
	public static void delete(int id) {
		String query = "DELETE FROM users WHERE id = "+id;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(query);
			pstm.execute();
			System.out.println("Registro Deletado!");
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
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
