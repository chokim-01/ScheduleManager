package com.web.backend.project.todo;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class TodoUpdateRequest {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime time;
    private Todo.Status status;
}
