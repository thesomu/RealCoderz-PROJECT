/**
* <h1>Delete DAO</h1>
* The delete dao get the task name and delete it from the database.
* 
* @author Somnath
*/
package com.realcoderz.registration.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.realcoderz.registration.model.delete;

public class deleteDAO {
	
	static final Logger logger = Logger.getLogger(deleteDAO.class);

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

		public boolean deletetask(delete Delete) 
		
		  /**
		   * This method is used to execute the sql delete query.
		   *
		   */
		
		{
			loadDriver(dbdriver);
			Connection con = getConnection();
			
			String taskdelete = Delete.getTaskdelete();			
			
		
			String sql = "delete from tasks where taskname='"+taskdelete+"'";
			try {
			
				PreparedStatement ps = con.prepareStatement(sql);
				
			 	System.out.println(ps);
			 	
			 	logger.debug("Executing query!");
			 	int rowsUpdate = ps.executeUpdate(sql);
			 	
				if(rowsUpdate>0) {
					logger.info("Entered task has been deleted!");
					System.out.println("Deleted Successfully");
					
				}
				else {
					logger.info("Task can't be deleted, Some !");
					System.out.println("Deletion failed");
					
				}
				return true;
			 	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
}
