package com.web.backend.project;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class ProjectCreateRequest {
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean publicOption;

    @Builder
    public ProjectCreateRequest(String name, String description, LocalDateTime startTime, LocalDateTime endTime, boolean publicOption) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.publicOption = publicOption;
    }
}
