package com.realcoderz.registration.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.realcoderz.registration.DAO.updateDAO;
import com.realcoderz.registration.model.update;

class updateDAOTest {
	
	private updateDAO updatedao = new updateDAO();

	@Test
	void updateTask() {
		
		update up = new update();
		
		up.setUpdatetask("test");
		up.setNewupdatetask("testing again!");
		
		assertTrue(updatedao.updatetask(up));
	}

	@Test
	void updatefailTask() {
		
		update up = new update();
		
		up.setUpdatetask("anything");
		up.setNewupdatetask("new task");
		
		assertTrue(updatedao.updatetask(up));
	}
}
