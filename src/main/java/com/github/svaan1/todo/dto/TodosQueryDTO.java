package com.github.svaan1.todo.dto;

import org.springframework.data.jpa.domain.Specification;

import com.github.svaan1.todo.entity.Todo;
import com.github.svaan1.todo.repository.spec.TodoSpecification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodosQueryDTO {
    private Boolean complete;

    public Specification<Todo> buildSpecification() {
        Specification<Todo> spec = null;

        if (this.complete != null) {
            spec = TodoSpecification.completeIsEqualTo(this.complete);
        }

        return spec;
    }
}
