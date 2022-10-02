package com.ainulmdrazibtw.todobackend;

import com.ainulmdrazibtw.todobackend.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TodobackendApplication {

	@Autowired
	TodoItemRepository todoItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodobackendApplication.class, args);
	}

}
