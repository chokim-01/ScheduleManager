package com.web.backend.project.issue;

import com.web.backend.user.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IssueDto {

    private Long id;
    private User user;
    private Long projectId;
    private Long todoId;
    private String title;
    private String content;
}
