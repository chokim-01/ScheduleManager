package com.web.backend.project;

import com.web.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProjectParticipant {
    enum Role{
        MANAGER, PARTICIPANT
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private User user;


    @Enumerated(EnumType.STRING)
    private Role role;


    public ProjectParticipant(Project project, User user, Role role) {
        this.project = project;
        this.user = user;
        this.role = role;
    }
}
