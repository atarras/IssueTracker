package com.fdmgroup.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import com.fdmgroup.dao.DBOperator;
import com.fdmgroup.model.Complaint;

public class ComplaintController extends DBOperator<Complaint> {
	public ComplaintController() {
		super();
	}
	
	public List<Complaint> getAllUnassignedComplaints(){
		open();
		
		TypedQuery<Complaint> query = entityManager.createNamedQuery("complaint.findAllUnassigned", Complaint.class);
		List<Complaint> complaints= query.getResultList();

		close();
		return complaints;
	}
	
	public Complaint getLastUserComplaint(long userID) {
		open();
		
		TypedQuery<Complaint> query = entityManager.createNamedQuery("complaint.findLastUserComplaint", Complaint.class);
		query.setParameter("id", userID);
		Complaint complaint= query.getResultList().get(0);

		close();
		return complaint;
	}
	
	@Override
	public Complaint insert(Complaint complaint) {
		open();
		entityManager.getTransaction().begin();
		entityManager.persist(complaint);
		entityManager.getTransaction().commit();
		close();
		
		Complaint lastUserComplaint = getLastUserComplaint(complaint.getUserID());
		return lastUserComplaint;
	}
	
	@Override
	public Complaint update(Complaint complaint) {
		open();
		
		Complaint managedComplaint = entityManager.find(Complaint.class, complaint.getComplaintID());
		entityManager.getTransaction().begin();
		
		if (complaint.getDepartment() != null && !complaint.getDepartment().equals("")) {
			managedComplaint.setDepartment(complaint.getDepartment());
		}

		if (complaint.getStatus() != null && !complaint.getStatus().equals("")) {
			managedComplaint.setStatus(complaint.getStatus());
		}

		if (complaint.getSubject() != null && !complaint.getSubject().equals("")) {
			managedComplaint.setSubject(complaint.getSubject());
		}

		if (complaint.getDescription() != null && !complaint.getDescription().equals("")) {
			managedComplaint.setDescription(complaint.getDescription());
		}

		entityManager.getTransaction().commit();

		close();
		return managedComplaint;
	}
	
	@Override
	public Complaint delete(Complaint complaint) {
		open();
		
		Complaint managedComplaint = entityManager.find(Complaint.class, complaint.getComplaintID());
		entityManager.getTransaction().begin();
		entityManager.remove(managedComplaint);
		entityManager.getTransaction().commit();
		
		close();
		return managedComplaint;
	}
	
	@Override
	public Complaint findByID(long id) {
		open();
		Complaint complaint = entityManager.find(Complaint.class, id);
		
		close();
		return complaint;
	}
	
	@Override
	public List<Complaint> getAll() {
		open();
		
		TypedQuery<Complaint> query = entityManager.createNamedQuery("complaint.findAll", Complaint.class);
		List<Complaint> complaints = query.getResultList();

		close();
		return complaints;
	}


}