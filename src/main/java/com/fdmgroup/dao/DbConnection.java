package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String USERNAME = "trainee1";
	private static final String PASSWORD = "!QAZSE4";
	// private static final String URL = "jdbc:oracle:thin:@devopsdb.c7iesyjfe3ry.us-east-1.rds.amazonaws.com:1521:ISSUEDB";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	private static Connection conn = null;

	public static Connection getConn() {
		return conn;
	}

	public static void connect() {

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (conn == null) {

			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		connect();
		close();
	}

}
