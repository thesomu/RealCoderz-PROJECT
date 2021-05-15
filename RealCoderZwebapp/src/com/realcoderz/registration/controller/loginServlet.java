/**
* <h1>Login Servlet</h1>
* Login servlet will verify the email and pwd to login
* 
*
* @author Somnath
* 
*/

package com.realcoderz.registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.realcoderz.registration.controller.showtasksServlet;

import com.realcoderz.registration.DAO.LoginDAO;
import com.realcoderz.registration.DAO.UsersDAO;
import com.realcoderz.registration.model.Login;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;



public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		static final Logger logger = Logger.getLogger(loginServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		* 
		* get the email and pwd
		* 
		* check weather the details are in database or not
		*
		* 
		*/	
		
		logger.info("Inside the login servlet!");
		
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
	
		Login login = new Login();
		 login.setEmail(email);
		 login.setPwd(password);
		
		LoginDAO loginDao = new LoginDAO();
		
		if(loginDao.retrieve(login))
		{
			logger.info("Redirect to details.html!");
			response.sendRedirect("details.html");
		}
		else 
		{
			logger.info("Redirect to register.html because login failed!");
			response.sendRedirect("register.html");
		}
		 
		}
	}


