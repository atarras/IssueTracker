package com.fdmgroup.model;

import java.util.ArrayList;

public class Customer {
	ArrayList<Complaint> complaints = new ArrayList<Complaint>();

	public Customer(ArrayList<Complaint> complaints) {
		super();
		this.complaints = complaints;
	}

	public void submitComplaint(Complaint newComplaint) {
		complaints.add(newComplaint);
	}

	public ArrayList<Complaint> getComplaints() {
		return complaints;
	}
}