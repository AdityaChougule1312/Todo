package com.TodoTask.controller;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TodoTask.data.TodoTask;
import com.TodoTask.data.TodoTaskSearch;
import com.TodoTask.service.TodoTaskService;

@RestController
public class TodoTaskController {
	@Autowired
	private TodoTaskService service;
	
	@RequestMapping("/display")
	public List<TodoTask> display() throws SQLException{
		return service.getAllTask();
	}

@RequestMapping("/add")
public TodoTask add(@RequestBody TodoTask task) throws SQLException {
	return service.addTask(task);
}
//@GetMapping("/update")
//public TodoTask update(TodoTask todoTask, Timestamp date) throws SQLException {
//	return service.updateTask(todoTask, date);
//}

@GetMapping("/bydates")
public List<TodoTask> getByDate(@RequestBody TodoTaskSearch dates) throws SQLException{
	return service.getTaskBetweenDates(dates);
}

}
