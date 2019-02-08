package com.fdmgroup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.fdmgroup.dao.DBoperations;
import com.fdmgroup.model.Complaint;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/admin")
public class AdminHomeServlet extends HttpServlet {
	List<Complaint> allComplaints = DBoperations.getAllComplaints();
	HttpSession session;
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		allComplaints = DBoperations.getAllComplaints();
		session.setAttribute("allComplaints", allComplaints);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/adminHomepage.jsp");
		
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		allComplaints = DBoperations.getAllComplaints();
		session.setAttribute("allComplaints", allComplaints);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/adminHomepage.jsp");
		rd.forward(request, response);
	}
}
