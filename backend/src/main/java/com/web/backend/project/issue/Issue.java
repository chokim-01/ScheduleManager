package com.web.backend.project.issue;

import com.web.backend.project.Project;
import com.web.backend.project.todo.Todo;
import com.web.backend.user.User;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Issue{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Project project;

    @ManyToOne
    private Todo todo;
    private String title;
    private String content;

    @Builder
    public Issue(User user, Project project, Todo todo, String title, String content) {
        this.user = user;
        this.project = project;
        this.todo = todo;
        this.title = title;
        this.content = content;
    }




    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
