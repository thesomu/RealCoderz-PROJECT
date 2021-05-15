/**
* <h1>task Servlet</h1>
* the task servlet, task inserts and added to the list with specified id number
*
*
* @author Somnath
* 
*/

package com.realcoderz.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.registration.DAO.TaskDAO;
import com.realcoderz.registration.model.Tasks;
import com.realcoderz.registration.controller.*;


public class taskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private TaskDAO taskDao = new TaskDAO();

	static final Logger logger = Logger.getLogger(taskServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		* 
		* takes the ID number 
		* 
		* add the task.
		*
		* 
		*/	
				
		
		logger.info("Inside the task servlet!");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String taskname = request.getParameter("taskname");
		PrintWriter out = response.getWriter();
		
		System.out.println(id+" "+taskname);
		Tasks tasks = new Tasks(id, taskname);
		
		
		TaskDAO taskDao = new TaskDAO();
		String result = taskDao.insert(tasks);
		response.getWriter().println(result);
		
		logger.info("Redirect to details after submitting the new task!");
		response.sendRedirect("details.html");
		
		}

}
