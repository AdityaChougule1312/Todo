package TodoTask.TodoTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.TodoTask.controller,"+"com.TodoTask.service,"+"com.TodoTask.data")
public class TodoTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoTaskApplication.class, args);
		System.out.println("Hello");
	}

}
