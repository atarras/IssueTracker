package com.fdmgroup.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

	private static final String USERNAME = "trainee1";
	private static final String PASSWORD = "!QAZSE4";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	private static Connection conn = null;

	
	
	public static Connection getConn() {
		return conn;
	}

	public static void connect() {

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (conn == null) {

			try  {
				
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				java.sql.Statement st = conn.createStatement();
				
				String query = "Select * from USERS";
				 ResultSet rs = st.executeQuery(query);
				
				 while (rs.next()) {
				 long id = rs.getInt("ID");
				 String fName = rs.getString("FIRSTNAME");
				 String lName = rs.getString("LASTNAME");
				 String type = rs.getString("TYPE");
				 String emailAddr = rs.getString("EMAIL");
				 String userName = rs.getString("USERNAME");
				 String pass = rs.getString("PASSWORD");
				
				 System.out.println(id + " " + fName + " " + lName + " " + type + " " +
				 emailAddr + " " + userName + " " + pass);
				 }
				
				
				 System.out.println("Users selected from correctly");
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public static void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	 public static void main(String[] args) {
	
	 connect();
	 close();
	 }

}
