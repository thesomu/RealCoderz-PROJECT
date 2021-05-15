package com.realcoderz.registration.model;

public class Tasks {
	
	private int id;
	public Tasks(int id, String taskname) {
		super();
		this.id = id;
		this.taskname = taskname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String taskname;

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public Tasks(String taskname) {
		super();
		this.taskname = taskname;
	}

	public Tasks() {
		super();
	}

	

}

