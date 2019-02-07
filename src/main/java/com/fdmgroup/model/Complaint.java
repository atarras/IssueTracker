package com.fdmgroup.model;

public class Complaint {
	
	private long complaintID;
	private long userID;
	private Department department;
	private Status status;
	private String subject;
	private String description;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
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
	
	
}
