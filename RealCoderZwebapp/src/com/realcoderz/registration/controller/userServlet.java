/**
* <h1>user Servlet</h1>
* the user servlet, to insert the user details for registration
*
*
* @author Somnath
* 
*/
package com.realcoderz.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.registration.DAO.UsersDAO;
import com.realcoderz.registration.model.Users;


public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final Logger logger = Logger.getLogger(userServlet.class);
	
	private UsersDAO usersDao = new UsersDAO();

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		* 
		* gets the userid, firstname, lastname, password, mail
		* 
		* stores and redirect to officetask.html from where user can login with the same details
		*
		* 
		*/	
		
		logger.info("Inside the user servlet!");
		
		int userid =Integer.parseInt(request.getParameter("userid"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		System.out.println(userid+" "+firstname+" "+lastname+" "+password+" "+mail);
		
		Users users = new Users(userid, firstname, lastname, password, mail);
		
		UsersDAO usersDao = new UsersDAO();
		String result = usersDao.insert(users);
		
		response.getWriter().println(result);
		
		logger.info("Redirect to officetask.html");
		response.sendRedirect("officetask.html");
		
		}

}
