/**
* <h1>Task DAO</h1>
* The task dao inserts the input tasks into the database.
* 
* @author Somnath
*/

package com.realcoderz.registration.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.realcoderz.registration.model.Tasks;

public class TaskDAO {
	
	static final Logger logger = Logger.getLogger(TaskDAO.class);

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
			}
			catch(SQLException e) {
				logger.info("Connection failed!");
				e.printStackTrace();
			}
			return con;
		}
		public String insert(Tasks tasks)
		

		  /**
		   * This method is used to execute the sql insert query.
		   *
		   */
		
		{
			loadDriver(dbdriver);
			Connection con = getConnection();
			String result = "task entered";
			String fail = "fail";
			String sql = "INSERT INTO tasks VALUES(?,?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, tasks.getId());
				ps.setString(2, tasks.getTaskname());
				logger.info("Executing query");
				ps.executeUpdate();
				
				
				if(tasks.getTaskname()==null||tasks.getTaskname()==""){
					throw new TaskNotEntered("This field is required!");
				}
				
				return result;
				
			} catch (SQLException | TaskNotEntered e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error "+e.getMessage());
				return fail;
			}
				
	}
}
