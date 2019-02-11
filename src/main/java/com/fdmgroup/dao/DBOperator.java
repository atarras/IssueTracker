package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Complaint;

public abstract class DBOperator <E>{
	protected EntityManager entityManager;

	public abstract E insert(E e);
	public abstract E update(E e);
	public abstract E delete(E e);
	public abstract E findByID(long id);
	public abstract List<E> getAll();
	
	public DBOperator() {
		super();
	}

	public List<Complaint> findByUserID(long userid){
		open();
		TypedQuery<Complaint> query = entityManager.createNamedQuery("complaint.findByUserID", Complaint.class);
		query.setParameter("userid", userid);
		
		List<Complaint> complaints= query.getResultList();
		close();
		return complaints;
	}
	
	protected void open() {
		entityManager = DBConnection.getInstance().getEntityManager();
	}
	
	protected void close() {
		entityManager.close();
	}
	
	
}

/*
package com.fdmgroup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.model.Customer;
import com.fdmgroup.model.Administrator;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.User;

public class DBoperations {

	static Statement smt = null;

	public static void addUser(User user) {

		DbConnection.connect();

		try {
			java.sql.Statement smt = DbConnection.getConn().createStatement();
			String query = "insert into users(firstname,lastname,type,email,username,password) values('"  + user.getFirstName() + "','"
					+ user.getLastName() + "','CUSTOMER','" + user.getEmailAddress() + "','" + user.getUserName()
					+ "','" + user.getPassword() + "')";
			smt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void addComplaint(Complaint complaint) {
		DbConnection.connect();

		try {
			java.sql.Statement smt = DbConnection.getConn().createStatement();
			String query = "insert into complaints(status,subject,description,userid) values('" + complaint.getStatus() + "','"
					+ complaint.getSubject() + "','" + complaint.getDescription() + "'," + complaint.getUserID() + ")";
					
			smt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static User getUser(String username) {

		DbConnection.connect();

		try {
			
			java.sql.Statement smt = DbConnection.getConn().createStatement();
			String query = "Select * from users where username='" + username + "'";
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

	public static List<Complaint> getUserComplaints(String username) {

		
		DbConnection.connect();
		List<Complaint> complaintsList = new ArrayList<Complaint>();

		try {
			java.sql.Statement smt = DbConnection.getConn().createStatement();
			String query = "Select * from complaints where userid=" + getUser(username).getUserID();
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
			String query = "Select * from complaints where department is null";
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
*/
