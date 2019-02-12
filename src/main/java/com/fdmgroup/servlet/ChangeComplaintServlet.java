package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.controller.ComplaintController;
import com.fdmgroup.model.Administrator;
import com.fdmgroup.model.Complaint;
import com.fdmgroup.model.Status;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ChangeComplaintServlet
 */
@WebServlet("/changeComplaint")
public class ChangeComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintController complaintController = new ComplaintController();
		boolean completed = (request.getParameter("completedCheckbox") != null);
		String newDepartment = request.getParameter("departmentSelect");
		Administrator admin = new Administrator((User) request.getSession().getAttribute("user"));
		long complaintID = Long.parseLong(request.getParameter("complaintID"));
		RequestDispatcher rd;
		
		Complaint currentComplaint = complaintController.findByID(complaintID);
		
		if(!currentComplaint.getDepartment().equals(newDepartment)) {
			admin.assignDepartment(complaintID, newDepartment);
			admin.setComplaintStatus(complaintID, Status.ASSIGNED.toString());
		} else {
			request.setAttribute("errorMsg", "Complaint not changed.");
		}

		if(completed) {
			admin.setComplaintStatus(complaintID, Status.COMPLETED.toString());
		}
		
		rd = request.getRequestDispatcher("/home");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
