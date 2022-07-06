package com.web.backend.project;


import com.web.backend.user.User;
import com.web.backend.user.UserDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean publicOption;
    private List<UserDto> managers= new ArrayList<>();
    private List<UserDto> participants = new ArrayList<>();

    @Builder
    public ProjectDto(Long id, String name, String description, LocalDateTime startTime, LocalDateTime endTime, Boolean publicOption) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.publicOption = publicOption;
    }
}
