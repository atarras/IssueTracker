package com.fdmgroup.model;

import java.util.ArrayList;

public class Administrator extends User {

	public Administrator(long userID, String firstName, String lastName, String userName, String emailAddress,
			String password) {
		super(userID, firstName, lastName, userName, emailAddress, password);
	}

	public void setComplaintStatus(int statusNum, Status stat) {

	}

	public void assignDepartment(int departmentNum, Department depart) {

	}

	public ArrayList<Complaint> viewAllComplaints() {
		return null;
	}

	public ArrayList<Complaint> viewUnassignedComplaints() {
		return null;
	}
}
