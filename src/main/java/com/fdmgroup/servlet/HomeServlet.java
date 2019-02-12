package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.model.Administrator;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.Customer;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardHome(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardHome(request,response);
	}
	
	private void forwardHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		User sessionUser = (User)session.getAttribute("user");
		String listTitle = null;
		
		List<Complaint> complaintList = new ArrayList<Complaint>();
		
		if(sessionUser.getType().equals("ADMIN")) {
			Administrator admin = new Administrator(sessionUser);
			complaintList = admin.viewAllComplaints();
			listTitle = "All Complaints";
		} else if(sessionUser.getType().equals("CUSTOMER")) {
			Customer customer = new Customer(sessionUser);
			complaintList = customer.getComplaints();
			listTitle = "My Complaints";
		} else {
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		request.setAttribute("listTitle",listTitle);
		request.setAttribute("complaintList", complaintList);
		rd = request.getRequestDispatcher("WEB-INF/views/userHomepage.jsp");
		rd.forward(request, response);
	}
	
	
}
