package com.web.backend.project.todo;

import com.web.backend.user.User;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TodoDto {

    private Long id;
    private Long projectId;
    private User user;
    private String title;
    private String content;
    private LocalDateTime time;
    private Todo.Status status;
}
