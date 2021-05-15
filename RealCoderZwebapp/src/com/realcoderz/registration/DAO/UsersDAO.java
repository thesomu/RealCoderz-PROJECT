/**
* <h1>Users DAO</h1>
* The user dao stores the users details into database.
* 
* @author Somnath
*/
package com.realcoderz.registration.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;
import javax.websocket.SendResult;
import javax.xml.ws.Response;

import org.apache.catalina.User;
import org.apache.log4j.Logger;

import com.realcoderz.registration.model.Users;
import com.sun.xml.internal.bind.v2.runtime.Location;

public class UsersDAO {
	
	static final Logger logger = Logger.getLogger(UsersDAO.class);

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
			}
			catch(SQLException e) {
				logger.info("Connection failed!");
				e.printStackTrace();
			}
			return con;
		}
		public String insert(Users users)
		

		  /**
		   * This method is used to execute the sql insert query.
		   *
		   */
		
		{
			loadDriver(dbdriver);
			Connection con = getConnection();
			String result = "registered successfully";
			String fail = "register fail";
			String sql = "INSERT INTO userdata VALUES(?,?,?,?,?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, users.getUserId());
				ps.setString(2, users.getFirstname());
				ps.setString(3, users.getLastname());
				ps.setString(4, users.getPassword());
				ps.setString(5,users.getEmail());
				
				logger.info("Executing query");
				ps.executeUpdate();
				logger.info("Data inserted!");
				return result;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return fail;
			}
				
	}
}
