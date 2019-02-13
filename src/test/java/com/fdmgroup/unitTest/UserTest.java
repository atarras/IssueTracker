package com.fdmgroup.unitTest;

import com.fdmgroup.controller.ComplaintController;
import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.Customer;
import com.fdmgroup.model.Type;
import com.fdmgroup.model.User;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	List<User> users;
	Complaint complaint;
	ComplaintController complaintController;
	UserController userController;
	File usersFile = new File("src\\test\\resources\\users.xlsx");
	String testSubject = "Testing";
	String testDescription = "Testing";

	@Before
	public void init() {
		users = new ArrayList<User>();
		userController = new UserController();
		complaintController = new ComplaintController();
		System.out.println("Starting test");
		populateUsers(usersFile);
	}

	@Test
	public void test_InsertionIntoUsersTable() {
		System.out.println("Inserting users in database...");
		for (User user : users) {
			userController.insert(user);
		}
	}
	
	@Test
	public void test_UpdateUserFirstName() {
		String newFirstName = "New Name";
		List<User> allRecords = userController.getAll();
		int randomNum = (int) (Math.random() * (allRecords.size() - 1));

		User user = userController.findByUsername(allRecords.get(randomNum).getUserName());
		user.setFirstName(newFirstName);

		userController.update(user);

		assertEquals(newFirstName, userController.findByID(user.getUserID()).getFirstName());
	}

	@Test
	public void test_DeleteValuesInsertedInTesting() {
		System.out.println("Deleting users in database...");
		User firstAddedUser = userController.findByUsername(users.get(0).getUserName());
		User lastAddedUser = userController.findByUsername(users.get(users.size() - 1).getUserName());
		for (long i = firstAddedUser.getUserID(); i <= lastAddedUser.getUserID(); i++) {
			User user = userController.findByID(i);
			userController.delete(user);
		}
	}
	
	@Test
	public void test_SubmitNewComplaint() {
		List<User> allRecords = userController.findByType("CUSTOMER");
		int randomNum = (int) (Math.random() * (allRecords.size() - 1));
		Customer randomCustomer = new Customer(allRecords.get(randomNum));
		
		randomCustomer.submitComplaint(testSubject, testDescription);
		
		Complaint lastComplaint = complaintController.getLastUserComplaint(randomCustomer.getUserID());
		
		assertTrue(lastComplaint.getDescription().equals(testDescription));
	}

	private void populateUsers(File file) {
		String[] cellStrings = new String[6];
		String fname, lname, type, email, user, pass;
		int i = 0;
		try (InputStream ExcelFileToRead = new FileInputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
				XSSFWorkbook test = new XSSFWorkbook()) {
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;

			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				i = 0;
				row = (XSSFRow) rows.next();
				if (row.getRowNum() == 0) {
					continue;
				}

				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
					cell = (XSSFCell) cells.next();
					cellStrings[i++] = cell.getStringCellValue();
				}
				fname = cellStrings[0];
				lname = cellStrings[1];
				type = cellStrings[2];
				email = cellStrings[3];
				user = cellStrings[4];
				pass = cellStrings[5];

				if (type.equals("CUSTOMER")) {
					users.add(new User(fname, lname, Type.CUSTOMER, user, email, pass));
				} else if (type.equals("ADMIN")) {
					users.add(new User(fname, lname, Type.ADMIN, user, email, pass));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
