package com.web.backend.project.todo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.web.backend.project.Project;
import com.web.backend.user.User;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
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

    @ManyToOne
    private Project project;
    @ManyToOne
    private User user;
    private String title;
    private String content;
    private LocalDateTime time;

    private Status status;


    public void changeStatus(Status status){
        this.status = status;
    }


}
