/**
* <h1>update Servlet</h1>
* the update servlet, to update the tasks in list
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

import org.apache.log4j.Logger;

import com.realcoderz.registration.DAO.updateDAO;
import com.realcoderz.registration.model.update;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	static final Logger logger = Logger.getLogger(UpdateServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		* 
		* to update the task,
		* 
		* takes the tasks name and updated task name, then change the value
		*
		* 
		*/	
			
		
		String updatetask = request.getParameter("updatetask");
		String newupdatetask = request.getParameter("newupdatetask");
	
		update Update = new update();
		 Update.setUpdatetask(updatetask);
		 Update.setNewupdatetask(newupdatetask);
		
		updateDAO updateDao = new updateDAO();
		
		if(updateDao.updatetask(Update))
		{
			logger.info("redirect to details.html");
			response.sendRedirect("details.html");
		}
		else 
		{
			logger.info("redirect to details.html");
			response.sendRedirect("details.html");
		}
	}

}
