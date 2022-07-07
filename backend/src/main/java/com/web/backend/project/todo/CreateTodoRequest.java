package com.web.backend.project.todo;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateTodoRequest {
    private Long projectId;
    private String title;
    private String content;
    private LocalDateTime time;
    private Todo.Status status;
}
