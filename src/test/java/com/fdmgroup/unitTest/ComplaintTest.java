package com.fdmgroup.unitTest;

import com.fdmgroup.controller.ComplaintController;
import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.Administrator;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.Department;
import com.fdmgroup.model.Status;

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
		String newDepartment = Department.HR.toString();
		int randomNum = (int) (Math.random() * (complaints.size() - 1));
		
		Complaint randomComplaint = complaints.get(randomNum);
		
		admin.assignDepartment(randomComplaint.getComplaintID(), newDepartment);
	}
	
	@Test
	public void test_SetNewStatus() {
		List<Complaint> complaints = complaintController.getAll();
		int randomNum = (int) (Math.random() * (complaints.size() - 1));
		Complaint randomComplaint = complaints.get(randomNum);
		String newStatus = Status.COMPLETED.toString();
		
		admin.setComplaintStatus(randomComplaint.getComplaintID(), newStatus);
	}
	
	@Test
	public void test_DeleteComplaint() {
		List<Complaint> complaints = complaintController.getAll();
		int randomNum = (int) (Math.random() * (complaints.size() - 1));
		Complaint randomComplaint = complaints.get(randomNum);
		Complaint deletedComplaint = complaintController.delete(randomComplaint);
		
		assertNull(complaintController.findByID(deletedComplaint.getComplaintID()));
	}
}
