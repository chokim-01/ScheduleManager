package com.web.backend.project.issue;

import lombok.Data;

@Data
public class IssueUpdateRequest {
    private String title;
    private String content;

}
