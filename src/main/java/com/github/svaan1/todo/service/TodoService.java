package com.github.svaan1.todo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.svaan1.todo.repository.TodoRepository;
import com.github.svaan1.todo.dto.TodosQueryDTO;
import com.github.svaan1.todo.entity.Todo;
import com.github.svaan1.todo.exception.TodoNotFoundException;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
    }

    public Page<Todo> findAll(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    public Page<Todo> query(TodosQueryDTO todosQueryDTO, Pageable pageable) {
        return todoRepository.findAll(todosQueryDTO.buildSpecification(), pageable);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
