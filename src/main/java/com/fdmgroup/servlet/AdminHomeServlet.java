package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.ComplaintController;
import com.fdmgroup.model.Complaint;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/admin")
public class AdminHomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardAdmin(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardAdmin(request,response);
	}

	private void forwardAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintController complaintController = new ComplaintController();
		List<Complaint> allComplaints = complaintController.getAll();
		HttpSession session;
		session = request.getSession();
		session.setAttribute("allComplaints", allComplaints);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/adminHomepage.jsp");
		rd.forward(request, response);
	}
}
