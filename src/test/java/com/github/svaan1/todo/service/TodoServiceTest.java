package com.github.svaan1.todo.service;

import static org.mockito.BDDMockito.given;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.github.svaan1.todo.entity.Todo;
import com.github.svaan1.todo.repository.TodoRepository;

public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void canCreateTodo() {
        Todo todo = new Todo();
        todo.setDescription("This is a test");
        todo.setComplete(false);

        given(todoRepository.save(todo)).willReturn(todo);

        Todo savedTodo = todoService.save(todo);

        assertThat(savedTodo).isNotNull();
        assertThat(savedTodo.getDescription()).isEqualTo("This is a test");
        assertThat(savedTodo.isComplete()).isEqualTo(false);
    }

    @Test
    public void canSearchAll() {
        Todo todo1 = Todo.builder()
                .description("This is a test, number 1")
                .complete(false)
                .build();
        Todo todo2 = Todo.builder()
                .description("This is a test, number 2")
                .complete(true)
                .build();
        given(todoRepository.findAll(PageRequest.of(0, 2))).willReturn(new PageImpl<>(List.of(todo1, todo2)));
        Page<Todo> savedTodos = todoService.findAll(PageRequest.of(0, 2));

        assertThat(savedTodos).isNotNull();
        assertThat(savedTodos.getSize()).isEqualTo(2);
    }

}
