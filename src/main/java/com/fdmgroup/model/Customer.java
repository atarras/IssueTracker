package com.fdmgroup.model;

import java.util.List;

import com.fdmgroup.controller.ComplaintController;
import com.fdmgroup.controller.UserController;

import java.util.ArrayList;

public class Customer extends User {
	private ArrayList<Complaint> complaints;
	private UserController userController;
	private ComplaintController complaintController;

	public Customer(long userID, String firstName, String lastName, String userName, String emailAddress,
			String password) {
		super(userID, firstName, lastName, "CUSTOMER", userName, emailAddress, password);
		complaints = new ArrayList<Complaint>();
		userController = new UserController();
		complaintController = new ComplaintController();
	}

	public Customer(String firstName, String lastName, String userName, String emailAddress, String password) {
		this(0,firstName, lastName, userName, emailAddress, password);
	}

	public Customer(User user) {
		this(user.getUserID(),user.getFirstName(),user.getLastName(),user.getUserName(),user.getEmailAddress(),user.getPassword());
	}

	public List<Complaint> getComplaints(String username) {
		User foundUser = userController.findByUsername(username);
		List<Complaint> usercomplaintList = userController.findByUserID(foundUser.getUserID());
		return usercomplaintList;
	}

	public void submitComplaint(String subject, String description) {
		long id = this.getUserID();
		Complaint insertedComplaint = complaintController.insert(new Complaint(id,"PENDING", subject, description));
		complaints.add(insertedComplaint);
	}
}