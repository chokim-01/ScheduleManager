package com.web.backend.project.todo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.web.backend.project.Project;
import com.web.backend.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo{



    enum Status{
        TODO, IN_PROGRESS, IN_REVIEW, DONE;

        @JsonCreator
        public static Status of(String s){
            return Status.valueOf(s.toUpperCase());
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(table = "project", name = "id")
    private Long projectId;
    @ManyToOne
    private User user;
    private String title;
    private String content;
    private LocalDateTime time;

    private Status status;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Builder
    public Todo(Long projectId, User user, String title, String content, LocalDateTime time, Status status) {
        this.projectId = projectId;
        this.user = user;
        this.title = title;
        this.content = content;
        this.time = time;
        this.status = status;
    }

    protected TodoDto toDto(){
        TodoDto todoDto = new TodoDto();
        todoDto.setTitle(title);
        todoDto.setId(id);
        todoDto.setContent(content);
        todoDto.setProjectId(projectId);
        todoDto.setUser(user);
        todoDto.setTime(time);
        todoDto.setStatus(status);
        return todoDto;
    }


}
