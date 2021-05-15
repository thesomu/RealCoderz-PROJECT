/**
* <h1>Update DAO</h1>
* The update dao update the inserted task to the new inserted task.
* 
* @author Somnath
*/
package com.realcoderz.registration.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.realcoderz.registration.model.delete;
import com.realcoderz.registration.model.update;

public class updateDAO {
	
	static final Logger logger = Logger.getLogger(updateDAO.class);

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
				logger.error("driver loading error!");
				e.printStackTrace();
				
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
		public boolean updatetask(update Update)
		

		  /**
		   * This method is used to execute the sql update query.
		   *
		   */
		
		{
			loadDriver(dbdriver);
			Connection con = getConnection();
			
			String updateTask = Update.getUpdatetask();			
			String newupdateTask = Update.getNewupdatetask();
		
			String sql = "update tasks set taskname='"+newupdateTask+"' where taskname='"+updateTask+"'";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
			 	System.out.println(ps);
			 	logger.info("Executing query");
			 	int rowsUpdate = ps.executeUpdate(sql);
			 	con.close();
			 	
				if(rowsUpdate>0) {
					logger.info("Task Updated");
					System.out.println("Update Successfully");
				}
				else {
					logger.info("Task updation failed");
					System.out.println("updation failed");
				}
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
				
	}
}
