package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/processLogin")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserController userController = new UserController();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User foundUser = userController.findByUsername(username);
		if (foundUser != null && foundUser.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(300);
			session.setAttribute("user", foundUser);
			
			RequestDispatcher rd = request.getRequestDispatcher("/home");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "Username/Password is wrong.");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
			rd.forward(request, response);
		}
	}
}























