package com.web.backend.project;

import com.web.backend.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Project {
    @Builder
    public Project(String name, String description, LocalDateTime startTime, LocalDateTime endTime, boolean publicOption) {
        this.inviteCode = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.publicOption = publicOption;
        generateInviteCode();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inviteCode;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean publicOption;



    protected void generateInviteCode() {
        this.inviteCode = UUID.randomUUID().toString();
    }

    public ProjectDto toDto(){
        return ProjectDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .startTime(startTime)
                .endTime(endTime)
                .publicOption(publicOption)
                .build();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setPublicOption(boolean publicOption) {
        this.publicOption = publicOption;
    }
}
