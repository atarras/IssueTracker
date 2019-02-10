package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPLAINTS")
@NamedQueries({
	@NamedQuery(name = "complaint.findAll", query = "SELECT c FROM Complaint c"),
	@NamedQuery(name = "complaint.findByUserID", query = "SELECT c FROM Complaint c WHERE c.userID = :userid"),
	@NamedQuery(name = "complaint.findByComplaintID", query = "SELECT c FROM Complaint c WHERE c.complaintID = :id"),
	@NamedQuery(name = "complaint.findAllUnassigned", query = "SELECT c FROM Complaint c WHERE c.status = 'PENDING'"),
})
@SequenceGenerator(name="COMPLAINTS_SEQ", sequenceName = "COMPLAINTS_SEQ", allocationSize = 1)
public class Complaint {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "COMPLAINTS_SEQ")
	private long complaintID;
	
	@Column(name = "userid")
	private long userID;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "description")
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
	
	public Complaint() {
		super();
	}

	public Complaint(long userID, String department, String status, String subject, String description) {
		super();
		this.userID = userID;
		this.department = department;
		this.status = status;
		this.subject = subject;
		this.description = description;
	}
	
	public Complaint(long userID, String status,String subject, String description) {
		super();
		this.userID = userID;
		this.subject = subject;
		this.status = status;
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
