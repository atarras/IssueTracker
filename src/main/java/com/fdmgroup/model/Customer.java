package com.fdmgroup.model;

import java.util.List;

import com.fdmgroup.controller.UserController;

import java.util.ArrayList;

public class Customer extends User {
	private ArrayList<Complaint> complaints;
	private UserController userController;

	public Customer(long userID, String firstName, String lastName, String userName, String emailAddress,
			String password) {
		super(userID, firstName, lastName, userName, emailAddress, password);
		complaints = new ArrayList<Complaint>();
		userController = new UserController();
	}

	public void submitComplaint(Complaint newComplaint) {
		complaints.add(newComplaint);
	}

	public Customer(String firstName, String lastName, String userName, String emailAddress, String password) {
		super(firstName, lastName, userName, emailAddress, password);
		complaints = new ArrayList<Complaint>();
		userController = new UserController();
	}

	public List<Complaint> getComplaints(String username) {
		User foundUser = userController.findByUsername(username);
		List<Complaint> usercomplaintList = userController.findByUserID(foundUser.getUserID());
		return usercomplaintList;
	}
}