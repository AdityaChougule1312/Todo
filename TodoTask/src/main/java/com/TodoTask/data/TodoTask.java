package com.TodoTask.data;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
@Component
public class TodoTask {
	
	private String taskId;
	private String taskName;
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd'T' HH:mm:ss.SSSX", shape = JsonFormat.Shape.STRING)
	private Timestamp taskDate;
	
	public TodoTask( String taskId,String taskName, Timestamp taskDate) {
	this.taskId=taskId;
	this.taskName=taskName;
	this.taskDate=taskDate;
	}

	public TodoTask() {}
	public String getTaskId() {
		return taskId;
	}

	

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Timestamp getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Timestamp taskDate) {
		this.taskDate = taskDate;
	}
	@Override
	public String toString() {
		return "TodoTask [taskId=" + taskId + ", taskName=" + taskName + ", taskDate=" + taskDate + "]";
	}
}
