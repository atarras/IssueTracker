package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.ComplaintController;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.Customer;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/submitComplaint")
public class ComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
		HttpSession session = request.getSession();
		Customer sessionUser = new Customer((User) session.getAttribute("user"));
		
		sessionUser.submitComplaint(subject, description);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/complaintSubmitted.jsp");
		rd.forward(request, response);
	}
}