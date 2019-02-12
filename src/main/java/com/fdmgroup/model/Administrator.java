package com.fdmgroup.model;

import java.util.List;

import com.fdmgroup.controller.ComplaintController;

public class Administrator extends User {
	private ComplaintController complaintController;
	
	public Administrator(long userID, String firstName, String lastName, String userName, String emailAddress,
			String password) {
		super(userID, firstName, lastName, Type.ADMIN, userName, emailAddress, password);
		complaintController = new ComplaintController();
	}

	public Administrator(String firstName, String lastName, String userName, String emailAddress, String password) {
		this(0,firstName, lastName, userName, emailAddress, password);
	}

	public Administrator(User user) {
		this(user.getUserID(),user.getFirstName(),user.getLastName(),user.getUserName(),user.getEmailAddress(),user.getPassword());
	}

	public void setComplaintStatus(long complaintID, String status) {
		Complaint foundComplaint = complaintController.findByID(complaintID);
		foundComplaint.setStatus(status);
		complaintController.update(foundComplaint);
	}

	public void assignDepartment(long complaintID, String department) {
		Complaint foundComplaint = complaintController.findByID(complaintID);
		foundComplaint.setDepartment(department);
		complaintController.update(foundComplaint);
	}

	public List<Complaint> viewAllComplaints() {
		return complaintController.getAll();
	}

	public List<Complaint> viewUnassignedComplaints() {
		return complaintController.getAllUnassignedComplaints();
	}
}
