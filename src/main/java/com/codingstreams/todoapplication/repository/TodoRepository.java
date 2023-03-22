package com.codingstreams.todoapplication.repository;

import com.codingstreams.todoapplication.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
