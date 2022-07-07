package com.web.backend.project;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Data
public class ProjectUpdateRequest {

    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean publicOption;
}
