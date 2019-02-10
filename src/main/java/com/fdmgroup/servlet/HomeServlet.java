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

import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.Administrator;
import com.fdmgroup.model.Complaint;
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
		UserController userController = new UserController();
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		User sessionUser = (User)session.getAttribute("user");
		
		List<Complaint> userComplaints = userController.findByUserID(sessionUser.getUserID());
		session.setAttribute("userComplaints", userComplaints);
		
		if(sessionUser instanceof Administrator) {
			rd = request.getRequestDispatcher("admin");
		} else {
			rd = request.getRequestDispatcher("WEB-INF/views/customerHomepage.jsp");
		}
		
		rd.forward(request, response);
	}
	
	
}
