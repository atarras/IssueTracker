package com.fdmgroup.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import com.fdmgroup.dao.DBOperator;
import com.fdmgroup.model.Administrator;
import com.fdmgroup.model.Customer;
import com.fdmgroup.model.User;

public class UserController extends DBOperator<User> {
	
	public UserController() {
		super();
	}
	
	@Override
	public User insert(User user){
		open();
		User newUser = null;
		entityManager.getTransaction().begin();
		if(user instanceof Customer) {
			newUser = new User(user.getFirstName(),user.getLastName(),"CUSTOMER",user.getEmailAddress(),user.getUserName(),user.getPassword());
		} else if (user instanceof Administrator) {
			newUser = new User(user.getFirstName(),user.getLastName(),"ADMIN",user.getEmailAddress(),user.getUserName(),user.getPassword());
		}
		
		entityManager.persist(newUser);
		entityManager.getTransaction().commit();
		
		close();
		return user;
	}
	
	@Override
	public User update(User user) {
		open();
		User managedUser = entityManager.find(User.class, user.getUserID());
		entityManager.getTransaction().begin();
		
		if (user.getUserName() != null && !user.getUserName().equals("")) {
			managedUser.setUserName(user.getUserName());
		}

		if (user.getPassword() != null && !user.getPassword().equals("")) {
			managedUser.setPassword(user.getPassword());
		}

		if (user.getFirstName() != null && !user.getFirstName().equals("")) {
			managedUser.setFirstName(user.getFirstName());
		}

		if (user.getLastName() != null && !user.getLastName().equals("")) {
			managedUser.setLastName(user.getLastName());
		}
		
		if (user.getEmailAddress() != null && !user.getEmailAddress().equals("")) {
			managedUser.setLastName(user.getLastName());
		}

		entityManager.getTransaction().commit();
		
		close();
		return managedUser;
	}

	@Override
	public User delete(User user){
		open();
		User managedUser = entityManager.find(User.class, user.getUserID());
		entityManager.getTransaction().begin();
		entityManager.remove(managedUser);
		entityManager.getTransaction().commit();

		close();
		return managedUser;
	}
	
	public User findByUsername(String username){
		open();
		TypedQuery<User> query = entityManager.createNamedQuery("user.findByUsername", User.class);
		query.setParameter("username", username);
		
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		
		close();
		return null;
	}

	@Override
	public User findByID(long id){
		open();
		User user = entityManager.find(User.class, id);
		
		close();
		return user;
	}
	
	@Override
	public List<User> getAll() {
		open();
		TypedQuery<User> query = entityManager.createNamedQuery("user.findAll", User.class);
		List<User> users = query.getResultList();

		close();
		return users;
	}
}