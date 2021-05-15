/**
* <h1>Delete Servlet</h1>
* The delete servlet get the task name and delete it from the database.
* 
* @author Somnath
*/
package com.realcoderz.registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.registration.DAO.deleteDAO;
import com.realcoderz.registration.model.Login;
import com.realcoderz.registration.model.delete;


public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	static final Logger logger = Logger.getLogger(taskServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/**
		* 
		* Get the parameter, parameter includes the taske name which has to be deleted
		* 
		*if condition satifies the task will be deleted
		*
		* 
		*/		
		
		logger.info("Inside the delete servlet!");
		
		String taskdelete = request.getParameter("taskdelete");

		delete dl = new delete();
		 dl.setTaskdelete(taskdelete);;
		 
		 deleteDAO deleteDao = new deleteDAO();
		 
		
			if(deleteDao.deletetask(dl))
			 {
				 logger.info("redirect to details.html after deleting the task!");
				 response.sendRedirect("details.html");
			 }
			 else {
				 logger.info("redirect to details.html if delete fails!");
				 response.sendRedirect("details.html");
			 }
	}

}
