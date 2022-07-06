package com.web.backend.project.todo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TodoDto {

    private Long id;
    private Long projectId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime time;
    private Todo.Status status;
}
