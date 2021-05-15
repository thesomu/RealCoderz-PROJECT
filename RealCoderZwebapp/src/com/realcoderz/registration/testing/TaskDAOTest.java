package com.realcoderz.registration.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.realcoderz.registration.DAO.TaskDAO;
import com.realcoderz.registration.model.Tasks;

class TaskDAOTest {

private TaskDAO taskdao = new TaskDAO();
	
	@Test
	void insertTaskTest() {

		Tasks task = new Tasks();
		
		task.setId(1);
		task.setTaskname("create a webapplication");
		
		String expected = "task entered";
		String actual = taskdao.insert(task);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void insertTaskFailTest() {
		
		Tasks task = new Tasks();
		
		task.setId(10);
		task.setTaskname("failtest");
		
		String expected = "fail";
		String actual = taskdao.insert(task);
		
		assertEquals(expected, actual);
		
	}

}
