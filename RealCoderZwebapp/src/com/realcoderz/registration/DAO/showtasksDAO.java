/**
* <h1>showtasks DAO</h1>
* The show tasks dao get the task name and delete it from the database.
* 
* @author Somnath
*/
package com.realcoderz.registration.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.realcoderz.registration.controller.loginServlet;
import com.realcoderz.registration.model.Login;
import com.realcoderz.registration.model.Tasks;
import com.realcoderz.registration.model.showtasks;

public class showtasksDAO {
	
	static final Logger logger = Logger.getLogger(showtasksDAO.class);

		private String dburl = "jdbc:mysql://localhost:3306/realcoderzproj?autoReconnect=true&useSSL=false";
		
		private String dbname = "root";
		private String dbpass="Somu@9555";
		private String dbdriver="com.mysql.cj.jdbc.Driver";
	
		public void loadDriver(String dbdriver) {
			
			 /**
			   * This method is used to load the driver
			   */
			
			try {
				logger.info("Loading driver!");
				Class.forName(dbdriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("driver loading error!");
			} 
		}
		
		public Connection getConnection() {
			
			  /**
			   * This method is used to establish connection
			   * 
			   */
			
			Connection con=null;
			try {
				logger.info("Esbilishing connection!");
				con=DriverManager.getConnection(dburl, dbname, dbpass);
				logger.info("Connection Successfull");
			}
			catch(SQLException e) {
				logger.info("Connection failed!");
				e.printStackTrace();
			}
			return con;
		}
		
			public List<showtasks> showlist()
			

			  /**
			   * This method is used to execute the sql select query.
			   *
			   */
			
			{
				        loadDriver(dbdriver);
						Connection con = getConnection();
						
						
					 
				String sql = "select * from tasks";
			 	
				List<showtasks> lists = new ArrayList<showtasks>();
				
				try {	
				PreparedStatement ps = con.prepareStatement(sql);
					
				 	System.out.println(ps);
				 	
				 	logger.info("Executing query");
				 	ResultSet rs = ps.executeQuery(sql);
				 	
				 	
				while(rs.next())
				{
					showtasks list = new showtasks();
					list.setTasks(rs.getString("taskname"));
					System.out.println(rs.getString("taskname"));
					
					lists.add(list);
				}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				
				return lists;
			
			
	}

		
}
