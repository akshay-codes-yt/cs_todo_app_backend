package com.codingstreams.todoapplication.controller;

import com.codingstreams.todoapplication.dto.TodoDto;
import com.codingstreams.todoapplication.exception.TodoNotFoundException;
import com.codingstreams.todoapplication.model.Todo;
import com.codingstreams.todoapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/")
    public Todo addTodo(@RequestBody TodoDto todoDto) {
        return todoService.addTodo(todoDto);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody TodoDto todoDto) throws TodoNotFoundException {
        return todoService.updateTodo(id, todoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Integer id) throws TodoNotFoundException {
        todoService.deleteTodo(id);
    }
}
