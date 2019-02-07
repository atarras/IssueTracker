package com.fdmgroup.model;

public class Complaint {
	
	private long complaintID;
	private long userID;
	private String department;
	private String status;
	private String subject;
	private String description;
	
	
	
	public Complaint(long complaintID, long userID,String department, String status, String subject,
			String description) {
		super();
		this.complaintID = complaintID;
		this.userID = userID;
		this.department = department;
		this.status = status;
		this.subject = subject;
		this.description = description;
	}
	
	public Complaint(long userID, String department, String status, String subject, String description) {
		super();
		this.userID = userID;
		this.department = department;
		this.status = status;
		this.subject = subject;
		this.description = description;
	}

	public long getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(long complaintID) {
		this.complaintID = complaintID;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Complaint [complaintID=" + complaintID + ", userID=" + userID + ", department=" + department
				+ ", status=" + status + ", subject=" + subject + ", description=" + description + "]";
	}
	
	
	
}
