package com.ainulmdrazibtw.todobackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="todo_items_table")
public class TodoItemDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private Boolean completed;

    @Column(name = "username")
    private String username;

}
