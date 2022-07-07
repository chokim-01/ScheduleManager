package com.web.backend.project.issue;

import lombok.Data;

@Data
public class IssueCreateRequest {
    private Long projectId;


    private Long todoId;
    private String title;
    private String content;

}
