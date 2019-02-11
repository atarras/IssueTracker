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

/**
 * Servlet implementation class ShowComplaintServlet
 */
@WebServlet("/seeComplaint")
public class ShowComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintController complaintController = new ComplaintController();
		long complaintID = (long) request.getAttribute("complaintID");
		HttpSession session = request.getSession();
		
		System.out.println("Complaint ID = " + complaintID);
		/*
		Complaint foundComplaint = complaintController.findByID(complaintID);
		
		if(foundComplaint != null) {
			session.setAttribute("complaintObject", foundComplaint);
		}
		*/
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/viewComplaint.jsp");
		rd.forward(request, response);
	}
}