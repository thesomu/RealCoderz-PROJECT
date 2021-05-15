package com.realcoderz.registration.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.realcoderz.registration.DAO.deleteDAO;
import com.realcoderz.registration.model.delete;

class deleteDAOTest {

		private deleteDAO deletedao = new deleteDAO();
		

	@Test
		void deleteTaskTest() {
			
			delete del = new delete();
			
			del.setTaskdelete("create a webapp");
			
			
			assertTrue(deletedao.deletetask(del));
			
		}
	@Test
	void deleteFailTaskTest(){
		
		delete del = new delete();
		
		del.setTaskdelete("testing");
		
		
		assertFalse(deletedao.deletetask(del));
		
	}

}
