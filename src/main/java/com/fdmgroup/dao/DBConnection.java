package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
	private static final String PERSISTENCE_UNIT = "IssueTracker";
	private static DBConnection connection = null;
	private EntityManagerFactory emf = null;
	
	private DBConnection(){
		init();
	}
	
	private void init() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
	}

	public static DBConnection getInstance() {
		if (connection == null) {
			connection = new DBConnection();
		}
		
		return connection;
	}
	
	public EntityManager getEntityManager() {
		init();
		return emf.createEntityManager();
	}
	
	public void close() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}
/*package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String USERNAME = "trainee1";
	private static final String PASSWORD = "!QAZSE4";
	private static final String URL = "jdbc:oracle:thin:@devopsdb.c7iesyjfe3ry.us-east-1.rds.amazonaws.com:1521:ISSUEDB";
	//private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

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
}*/
