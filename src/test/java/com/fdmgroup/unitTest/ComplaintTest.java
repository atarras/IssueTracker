package com.fdmgroup.unitTest;

import com.fdmgroup.controller.ComplaintController;
import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.Administrator;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.Department;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComplaintTest {
	Complaint complaint;
	ComplaintController complaintController;
	UserController userController;
	String testSubject = "Testing";
	String testDescription = "Testing";
	String testStatus = "PENDING";
	Administrator admin;

	@Before
	public void init() {
		complaintController = new ComplaintController();
		complaint = new Complaint(2, testStatus, testSubject, testDescription);
		admin = new Administrator("Gabriel", "Moreira", "gmmeng", "admin@fdm.com", "1234");
	}

	@Test
	public void test_InsertNewComplaint() {
		List<Complaint> complaintsBefore = complaintController.getAll();
		complaintController.insert(complaint);
		List<Complaint> complaintsAfter = complaintController.getAll();
		
		assertEquals(complaintsBefore.size()+1, complaintsAfter.size());
	}
	
	@Test
	public void test_SetNewDepartment() {
		List<Complaint> complaints = complaintController.getAll();
		String newDepartment = Department.Financial.toString();
		int randomNum = (int) (Math.random() * (complaints.size() - 1));
		
		Complaint randomComplaint = complaints.get(randomNum);
		
		admin.assignDepartment(randomComplaint.getComplaintID(), newDepartment);
	}
}
