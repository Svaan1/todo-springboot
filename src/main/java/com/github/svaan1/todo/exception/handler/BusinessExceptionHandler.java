package com.github.svaan1.todo.exception.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.svaan1.todo.dto.ApiErrorDTO;
import com.github.svaan1.todo.exception.TodoNotFoundException;

@RestControllerAdvice
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<Object> handleTodoNotFoundException(TodoNotFoundException ex) {
        ApiErrorDTO apiErrorDTO = ApiErrorDTO.builder()
                .message("No todo found with given id")
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrorDTO);
    }
}
