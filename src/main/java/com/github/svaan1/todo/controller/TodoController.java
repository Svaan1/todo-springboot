package com.github.svaan1.todo.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.svaan1.todo.dto.TodosQueryDTO;
import com.github.svaan1.todo.entity.Todo;
import com.github.svaan1.todo.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public Page<Todo> findAll(Pageable pageable) {
        return todoService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @GetMapping("/query")
    public Page<Todo> query(TodosQueryDTO todosQueryDTO, Pageable pageable) {
        return todoService.query(todosQueryDTO, pageable);
    }

    @PostMapping
    public Todo create(@RequestBody @Valid Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping
    public Todo update(@RequestBody @Valid Todo todo) {
        return todoService.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        todoService.deleteById(id);
    }
}