/**
* <h1>Login DAO</h1>
* The login dao checks the entered details exists in database or not.
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

import com.realcoderz.registration.controller.loginServlet;
import com.realcoderz.registration.model.Login;

public class LoginDAO {
	
	static final Logger logger = Logger.getLogger(LoginDAO.class);

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
			}
			catch(SQLException e) {
				logger.info("Connection failed!");
				e.printStackTrace();
			}
			return con;
		}
		public boolean retrieve(Login login)
		

		  /**
		   * This method is used to execute the sql select query.
		   *
		   */
		
		{
			loadDriver(dbdriver);
			Connection con = getConnection();
			
			String loginEmail = login.getEmail();
			String loginPass = login.getPwd();
			
		
			String sql = "select * from userdata where email='"+loginEmail+"' and password='"+loginPass+"'";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				
			 	System.out.println(ps);
			 	
			 	logger.info("Executing query");
			 	ResultSet rs = ps.executeQuery(sql);
			 	
			 	
				if(rs.next()) {
					
					return true;
				}
			 	
			 	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			return false;
	}
}
