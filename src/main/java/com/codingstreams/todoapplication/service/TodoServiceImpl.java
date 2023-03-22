package com.codingstreams.todoapplication.service;

import com.codingstreams.todoapplication.dto.TodoDto;
import com.codingstreams.todoapplication.exception.TodoNotFoundException;
import com.codingstreams.todoapplication.model.Todo;
import com.codingstreams.todoapplication.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodos() {
        // Fetch all todos
        Iterable<Todo> todoIterable = todoRepository.findAll();

        // Convert iterable into list
        List<Todo> todos = new ArrayList<>();
        todoIterable.forEach(todos::add);

        return todos;
    }

    @Override
    public Todo addTodo(TodoDto todoDto) {
        // Convert todo dto -> todo entity object
        Todo todo = todoDto.convertToEntity();

        // Save todo
        Todo savedTodo = todoRepository.save(todo);

        // Return saved todo
        return savedTodo;
    }

    @Override
    public Todo updateTodo(Integer id, TodoDto todoDto) throws TodoNotFoundException {
        // check if todo exists or not
        boolean exists = todoRepository.existsById(id);

        // if not exists then throw exception
        if (!exists) throw new TodoNotFoundException();

        // update todo
        Todo todo = todoDto.convertToEntity();
        todo.setId(id);

        // save todo
        Todo savedTodo = todoRepository.save(todo);

        // return saved todo
        return savedTodo;
    }

    @Override
    public void deleteTodo(Integer id) throws TodoNotFoundException {
        // check if todo exists or not
        boolean exists = todoRepository.existsById(id);

        // if not exists then throw exception
        if (!exists) throw new TodoNotFoundException();

        todoRepository.deleteById(id);
    }
}
