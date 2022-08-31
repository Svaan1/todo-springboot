package com.github.svaan1.todo.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import com.github.svaan1.todo.entity.Todo;

public class TodoSpecification {

    public static Specification<Todo> completeIsEqualTo(Boolean complete) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("complete"), complete);
    }
}
