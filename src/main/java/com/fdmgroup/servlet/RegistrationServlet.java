package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.controller.UserController;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String confemail = request.getParameter("confemail");
		String password = request.getParameter("password");
		String confpassword = request.getParameter("confpassword");
		
		UserController userController = new UserController();
		
		if(!password.equals(confpassword)) {
			request.setAttribute("errorMsg", "Password is not matching");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		} else if (!email.equals(confemail)){
			request.setAttribute("errorMsg", "Email is not matching");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}else {
			User newUser = new User(firstName,lastName,username,email,password);
			
			userController.insert(newUser);
			
			request.setAttribute("user", newUser);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registerConfirmation.jsp");
			rd.forward(request, response);
		}
		
	}
}