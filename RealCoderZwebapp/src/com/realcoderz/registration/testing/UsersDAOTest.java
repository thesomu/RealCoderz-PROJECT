package com.realcoderz.registration.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.realcoderz.registration.DAO.LoginDAO;
import com.realcoderz.registration.DAO.UsersDAO;
import com.realcoderz.registration.model.Users;

	class UsersDAOTest {

		UsersDAO reg = new UsersDAO();
		
		@Test
		void userRegisteredTest() {
			
			Users user = new Users();
			
			user.setUserId(8);
			user.setFirstname("Aakash");
			user.setLastname("Kumar");
			user.setPassword("aakash@123");
			user.setEmail("aakash@gmail.com");
			
			String expected = ("registered successfully");
			String actual = reg.insert(user);
			
			assertEquals(expected, actual);
			
		}
		
		@Test
		void userRegisterFail() {
			Users user = new Users();
			
			user.setEmail("nitin@gmail.com");
			user.setFirstname("Nitin");
			user.setLastname("Kumar");
			user.setPassword("nitin@123");
			user.setUserId(1);
			
			String expected = "register fail";
			String actual = reg.insert(user);
			
			assertEquals(expected, actual);
			
		}

}
