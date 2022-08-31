package com.github.svaan1.todo.dto;

import java.time.Instant;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorDTO {
    private String message;
    private Instant timestamp;
}
