package com.fdmgroup.model;

import java.util.List;

import com.fdmgroup.dao.DBoperations;

public class Administrator extends User {
	

	public Administrator(long userID, String firstName, String lastName, String userName, String emailAddress,
			String password) {
		super(userID, firstName, lastName, userName, emailAddress, password);
	}

	public void setComplaintStatus(int statusNum, Status stat) {
		
	}

	public void assignDepartment(int departmentNum, Department depart) {
		
	}

	public List<Complaint> viewAllComplaints() {
		List<Complaint> complaintList = DBoperations.getAllComplaints();
		return complaintList;
	}

	public List<Complaint> viewUnassignedComplaints() {
		List<Complaint> UnassignedComplaintList =  DBoperations.getAllUnassignedComplaints();
		return UnassignedComplaintList;
	}
}
