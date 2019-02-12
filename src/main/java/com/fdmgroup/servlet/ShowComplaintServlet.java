package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.controller.ComplaintController;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.Department;

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
		ComplaintController complaintController = new ComplaintController();
		long complaintID = Long.parseLong(request.getParameter("complaint"));
		Complaint requestComplaint = complaintController.findByID(complaintID);
		
		request.setAttribute("complaintObject", requestComplaint);
		request.setAttribute("departmentArr", Department.values());
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/viewComplaint.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}