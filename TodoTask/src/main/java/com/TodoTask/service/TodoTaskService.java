package com.TodoTask.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TodoTask.data.TodoTaskSearch;
import com.TodoTask.data.TodoTask;
@Component
public class TodoTaskService {
	@Autowired
	private TodoTask todoTask;
	

	
	private String jdbcurl="jdbc:sqlite:/D:\\SQLite\\sqlite-tools-win32-x86-3410100\\TodoTaskdb.db";
	Connection connection= null;
	
	
	//display all tasks
	public List<TodoTask> getAllTask() throws SQLException{
	List<TodoTask> allTasks= new ArrayList<>();	
	
	
	
	try {
		String sql= "SELECT * FROM TodoTask";
		connection= DriverManager.getConnection(jdbcurl);
		Statement statement= connection.createStatement();
		ResultSet result= statement.executeQuery(sql);
		
		while(result.next()) {
			String taskId= result.getString("taskId");
			String taskName= result.getString("taskName");
			
			Timestamp taskDate= result.getTimestamp("taskDate");
			
			System.out.println(taskId+" | "+taskName+" | "+taskDate );
			
			TodoTask todotask= new TodoTask(taskId,taskName,taskDate);
			
			allTasks.add(todotask);
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		connection.close();
	}
	
	return allTasks;
	}
	
	
	//insert into task
	//public void addTask(String taskName Timestamp taskDate) {}
	public TodoTask addTask(TodoTask task) throws SQLException {
		//Connection connection= null;
		UUID uuid= UUID.randomUUID();
		
		String taskId= null;
		
		if(task.getTaskId()==null) {
			
		 taskId= uuid.toString();
		}else {
			taskId=task.getTaskId();
		}
		
		
		//get from the task
		String taskName= task.getTaskName();
		Timestamp taskDate= task.getTaskDate();
		
		
		try {
			String sql= "INSERT INTO TodoTask VALUES (' "+ taskId +"'"+","+"'"+taskName+"'"+","+"'"+taskDate+"');" ;
			connection= DriverManager.getConnection(jdbcurl);
			Statement statement= connection.createStatement();
			//ResultSet result= statement.executeQuery(sql);
			statement.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		
		
		
		return task;
	}
	
	
	
	//update time to task
	public TodoTask updateTask(TodoTask todoTask, Timestamp newDate) throws SQLException {
		//String taskId= task.getTaskId();
		//task.setTaskDate(ddate);
		try {
			String sql="UPDATE TodoTask SET taskDate = "+"'"+newDate+"'"+" WHERE taskId = "+"'"+todoTask.getTaskId()+"';";
			connection= DriverManager.getConnection(jdbcurl);
			Statement statement=connection.createStatement() ;
			ResultSet result= statement.executeQuery(sql);
			while(result.next()) {
				String id= result.getString("taskId");
				String name= result.getString("taskName");
				
				Timestamp date= result.getTimestamp("taskDate");
				
				System.out.println(id+" | "+name+" | "+date );
				
				
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
		return todoTask;
	}
	
	
	
	
	//get task between dates
	public List<TodoTask> getTaskBetweenDates(TodoTaskSearch dates) throws SQLException{
		List<TodoTask> tasks= new ArrayList<>();
		try {
			String sql= "SELECT * FROM TodoTask WHERE taskDate BETWEEN "+ "'"+dates.getFromDate()+"'"+" AND "+"'"+ dates.getToDate()+"' ;";
			connection= DriverManager.getConnection(jdbcurl);
			Statement statement= connection.createStatement();
			ResultSet result= statement.executeQuery(sql);
			
			while(result.next()) {
				String taskId= result.getString("taskId");
				String taskName= result.getString("taskName");
				
				Timestamp taskDate= result.getTimestamp("taskDate");
				
				System.out.println(taskId+" | "+taskName+" | "+taskDate );
				
				TodoTask todotask= new TodoTask(taskId,taskName,taskDate);
				
				tasks.add(todotask);
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
		
		return tasks;
	}


}
