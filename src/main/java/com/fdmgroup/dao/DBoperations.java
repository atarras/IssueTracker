package com.fdmgroup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.model.Customer;
import com.fdmgroup.model.Department;
import com.fdmgroup.model.Status;
import com.fdmgroup.model.Administrator;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.User;

public class DBoperations {

	static Statement smt = null;

	public static User getUser(long id) {

		DbConnection.connect();

		try {
			java.sql.Statement smt = DbConnection.getConn().createStatement();
			String query = "Select * from users where id=" + id;
			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {

				String type = rs.getString("TYPE");
				if (type.equals("ADMIN")) {
					Administrator admin = new Administrator(rs.getLong("ID"), rs.getString("FIRSTNAME"),
							rs.getString("LASTNAME"), rs.getString("USERNAME"), rs.getString("EMAIL"),
							rs.getString("PASSWORD"));
					return admin;
				} else {
					Customer customer = new Customer(rs.getLong("ID"), rs.getString("FIRSTNAME"),
							rs.getString("LASTNAME"), rs.getString("USERNAME"), rs.getString("EMAIL"),
							rs.getString("PASSWORD"));
					return customer;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Complaint> getAllComplaints() {

		DbConnection.connect();
		List<Complaint> complaintsList = new ArrayList<Complaint>();

		try {
			java.sql.Statement smt = DbConnection.getConn().createStatement();
			String query = "Select * from complaints";
			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {

				Complaint complaint = new Complaint(rs.getLong("ID"), rs.getLong("USERID"), rs.getString("DEPARTMENT"),
						rs.getString("STATUS"), rs.getString("SUBJECT"), rs.getString("DESCRIPTION"));

				complaintsList.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return complaintsList;
	}
	
	public static List<Complaint> getUserComplaints(long id) {

		DbConnection.connect();
		List<Complaint> complaintsList = new ArrayList<Complaint>();

		try {
			java.sql.Statement smt = DbConnection.getConn().createStatement();
			String query = "Select * from complaints where userid=" + id;
			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {

				Complaint complaint = new Complaint(rs.getLong("ID"), rs.getLong("USERID"), rs.getString("DEPARTMENT"),
						rs.getString("STATUS"), rs.getString("SUBJECT"), rs.getString("DESCRIPTION"));

				complaintsList.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return complaintsList;
	}
	
	public static List<Complaint> getAllUnassignedComplaints() {

		DbConnection.connect();
		List<Complaint> complaintsList = new ArrayList<Complaint>();

		try {
			java.sql.Statement smt = DbConnection.getConn().createStatement();
			String query = "Select * from complaints where department is null" ;
			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {

				Complaint complaint = new Complaint(rs.getLong("ID"), rs.getLong("USERID"), rs.getString("DEPARTMENT"),
						rs.getString("STATUS"), rs.getString("SUBJECT"), rs.getString("DESCRIPTION"));

				complaintsList.add(complaint);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return complaintsList;
	}


}
