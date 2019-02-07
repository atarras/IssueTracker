package com.fdmgroup.model;

import java.util.ArrayList;

public class Customer extends User{
	ArrayList<Complaint> complaints;

	public Customer(long userID, String firstName, String lastName, String userName, String emailAddress, String password) {
		super(userID, password, password, password, password, password);
		complaints =  new ArrayList<Complaint>();
	}

	public void submitComplaint(Complaint newComplaint) {
		complaints.add(newComplaint);
	}

	public ArrayList<Complaint> getComplaints() {
		return complaints;
	}
}