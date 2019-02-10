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
@Table(name = "USERS")
@NamedQueries({
	@NamedQuery(name = "user.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "user.findByUsername", query = "SELECT u FROM User u WHERE u.userName = :username"),
})
@SequenceGenerator(name="U_SEQ", sequenceName = "U_SEQ", allocationSize = 1)
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "U_SEQ")
	private long userID;

	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "email")
	private String emailAddress;

	@Column(name = "username", unique = true)
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	public User() {
		super();
	}

	public User(long userID, String firstName, String lastName, String userName, String emailAddress, String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String userName, String emailAddress, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public User(String firstName, String lastName, String type, String emailAddress, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.emailAddress = emailAddress;
		this.userName = userName;
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", type=" + type + ", userName=" + userName + ", password=" + password + "]";
	}
	
	

}
