package com.codingstreams.todoapplication.service;

import com.codingstreams.todoapplication.dto.TodoDto;
import com.codingstreams.todoapplication.exception.TodoNotFoundException;
import com.codingstreams.todoapplication.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos();

    Todo addTodo(TodoDto todoDto);

    Todo updateTodo(Integer id, TodoDto todoDto) throws TodoNotFoundException;

    void deleteTodo(Integer id) throws TodoNotFoundException;
}
