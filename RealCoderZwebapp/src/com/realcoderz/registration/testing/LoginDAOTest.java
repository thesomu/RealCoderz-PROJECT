package com.realcoderz.registration.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.realcoderz.registration.DAO.LoginDAO;
import com.realcoderz.registration.model.Login;

class LoginDAOTest {
	
	private LoginDAO ld = new LoginDAO();

	@Test
	void loginTest() {
		
		Login login = new Login();
		
		login.setEmail("somnathmishra131@gmail.com");
		login.setPwd("Somu@9555");
		
		assertTrue(ld.retrieve(login));
		
	}
	
	@Test
	void loginFailTest() {
		
		Login login = new Login();
		
		login.setEmail("somnathmishra@gmail.com");
		login.setPwd("Somu@9555");
		
		assertFalse(ld.retrieve(login));
		
	}

}
