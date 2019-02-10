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
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/submitComplaint")
public class ComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintController complaintController = new ComplaintController();
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("user");
		
		
		Complaint complaint = new Complaint(sessionUser.getUserID(),"PENDING", subject, description);
		complaintController.insert(complaint);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/complaintSubmissionConfirmation.jsp");
		rd.forward(request, response);
	}
}























