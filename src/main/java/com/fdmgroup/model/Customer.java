package com.fdmgroup.model;

import java.util.List;
import java.util.ArrayList;

import com.fdmgroup.dao.DBoperations;

public class Customer extends User{
	ArrayList<Complaint> complaints;
	
	public Customer(long userID, String firstName, String lastName, String userName, String emailAddress, String password) {
		super(userID, firstName, lastName, userName, emailAddress, password);
		complaints =  new ArrayList<Complaint>();
	}

	public void submitComplaint(Complaint newComplaint) {
		complaints.add(newComplaint);
	}

	public  List<Complaint> getComplaints(String username) {
		
		 List<Complaint> usercomplaintList=DBoperations.getUserComplaints(username);
		return usercomplaintList;
	}
}