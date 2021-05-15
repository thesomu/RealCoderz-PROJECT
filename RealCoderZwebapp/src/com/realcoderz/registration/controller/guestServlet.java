/**
* <h1>Guest Servlet</h1>
* The Guest servlet shows the list of task from the database.
* 
*
* @author Somnath
* 
*/
package com.realcoderz.registration.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.registration.DAO.LoginDAO;
import com.realcoderz.registration.DAO.showtasksDAO;
import com.realcoderz.registration.model.Login;
import com.realcoderz.registration.model.showtasks;


public class guestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	static final Logger logger = Logger.getLogger(guestServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		* 
		* Tasks name are stored in the list and will be shown to the 
		* 
		* using for loop all the lists elemets will be shown
		*
		* 
		*/	
		logger.info("Inside the guest servlet!");
		PrintWriter out = response.getWriter();
		 
		 
		showtasks showTasks = new showtasks();
		showtasksDAO showtasksDao = new showtasksDAO();
		List<showtasks> list = showtasksDao.showlist(); 
		 
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
		out.print("<title>Office Task Management</title>");
		out.print("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.print("<link rel='stylesheet' type='text/css' media='screen' href='main.css'>");
		out.print("<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>");
		out.print("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>");    
		out.print("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>");
		out.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">");    
		out.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\">");

		out.print("</head>");
		out.print("<style>");
		out.print("fieldset.fldset");
		out.print("{");
		out.print("font-style:italic;");
		out.print("text-align:center;");
		out.print("font-size:medium;"); 
		out.print("text-align:center;");
		out.print("}");
		out.print("fieldset {");
		out.print("display: block; margin-inline-start: 2px; margin-inline-end: 2px;padding-block-start: 0.35em;\r\n" + 
				"		     padding-inline-start: 0.75em;\r\n" + 
				"		     padding-inline-end: 0.75em;\r\n" + 
				"		     padding-block-end: 0.625em;\r\n" + 
				"		     min-inline-size: min-content;\r\n" + 
				"		     border-width: 2px;\r\n" + 
				"		     border-style: groove;\r\n" + 
				"		     border-color: threedface;\r\n" + 
				"		     border-image: initial;}"+
				"			 table, th, td {"+
				"			 border: 1px solid black;"+
				"			 }");
		out.print("</style>");   
		out.print("<body style=\"background-color:#f0eeee;)\">\r\n" + 
				"		     <nav class=\"navbar navbar-expand-md navbar-dark bg-dark sticky-top\">\r\n" + 
				"		         <span class=\"navbar-brand\">RealCoderZ</span>\r\n" + 
				"		         <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#col_target\">\r\n" + 
				"		         <span class=\"navbar-toggler-icon\"></span></button>\r\n" + 
				"		         <div class=\"collapse navbar-collapse\" id=\"col_target\">      \r\n" + 
				"		             <ul class=\"navbar-nav ml-auto\">\r\n" + 
				"		                 <li class=\"nav-item\"><a class=\"nav-link\" href=\"home.html\">Home</a></li>\r\n" + 
				"		                 <li class=\"nav-item\"><a class=\"nav-link\" href=\"about.html\">About</a></li>\r\n" + 
				"		                 <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Contact</a></li>\r\n" + 
				"		                 <li class=\"nav-item\"><a class=\"nav-link\" href=\"blogs.html\">Blogs</a></li>\r\n" + 
				"		             </ul>\r\n" + 
				"		         </div>\r\n" + 
				"		     </nav>\r\n" + 
				"        <ol class=\"breadcrumb\">\r\n" + 
				"    	<li class=\"breadcrumb-item\"><a href=\"home.html\">Home</a></li>\r\n" + 
				"		<li class=\"breadcrumb-item active\"  aria-current=\"page\">Tasks List</li>"+
				"  		</ol>"+
				"		<div class = \"container-fluid\">\r\n" + 
				"        <div class=\"row\">\r\n" + 
				"         <div class=\"col-md-6\">\r\n" + 
				"        	\r\n" + 
				"            <img src=\"logo.png\" width=\"100%\" alt=\"image\" style=\"margin: 30px 0px 20px 0px;\" class=\"img-fluid\">  \r\n" + 
				"            \r\n" + 
				"        </div>\r\n" + 
				"            <div class=\"col-md-6\">"+
			
				"<table style=\"width:100%; margin: 30px 0px 20px 0px;\">\r\n" + 
		 		"  <tr>\r\n" + 
		 		"    <th style=\"text-align:center;\">TASKS TO BE DONE!</th>\r\n" + 
		 		"	</tr>");   	 
		 for(showtasks lists:list) {
			 logger.info("Showing  the list of tasks!");
			 out.print("	 <tr>"+
			 		"    <td>"+lists.getTasks()+"</td>"+
			 "</tr>");
		 }
		 out.print(
				 "	</table"+
				 "	</div>"+
				 "  <button type=\"button\" onClick=\"location.href='officetask.html'\">Modify</button>"+
				 "	</div>");
		 						
		 out.print("</body>\r\n" + 
		 		"</html>");
	}
}
