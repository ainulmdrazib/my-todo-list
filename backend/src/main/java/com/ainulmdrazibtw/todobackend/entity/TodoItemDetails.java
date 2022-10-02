package com.ainulmdrazibtw.todobackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Entity
//@Table(name="todo_items_table")
@Document("todoitems")
public class TodoItemDetails {

    @MongoId
    private String id;

    private String title;
    private Boolean completed = false;
    private String username;

}
