package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Complaint;

public abstract class DBOperator <E>{
	protected EntityManager entityManager;
	private DBConnection connection;
	public abstract E insert(E e);
	public abstract E update(E e);
	public abstract E delete(E e);
	public abstract E findByID(long id);
	public abstract List<E> getAll();
	
	public DBOperator() {
		super();
		connection = DBConnection.getInstance();
	}

	public List<Complaint> findByUserID(long userid){
		open();
		TypedQuery<Complaint> query = entityManager.createNamedQuery("complaint.findByUserID", Complaint.class);
		query.setParameter("userid", userid);
		
		List<Complaint> complaints= query.getResultList();
		close();
		return complaints;
	}
	
	protected void open() {
		entityManager = connection.getEntityManager();
	}
	
	protected void close() {
		entityManager.close();
	}
}