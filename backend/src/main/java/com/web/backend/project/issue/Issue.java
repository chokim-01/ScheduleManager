package com.web.backend.project.issue;

import com.web.backend.project.Project;
import com.web.backend.project.todo.Todo;
import com.web.backend.project.todo.TodoDto;
import com.web.backend.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Issue{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @JoinColumn(table = "project",name = "id")
    private Long projectId;

    @JoinColumn(table = "todo", name = "id")
    private Long todoId;
    private String title;
    private String content;

    @Builder
    public Issue(User user, Long projectId, Long todoId, String title, String content) {
        this.user = user;
        this.projectId = projectId;
        this.todoId = todoId;
        this.title = title;
        this.content = content;
    }




    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public IssueDto toDto() {
        IssueDto issue = new IssueDto();
        issue.setId(id);
        issue.setUser(user);
        issue.setContent(content);
        issue.setProjectId(projectId);
        issue.setTodoId(todoId);
        return issue;
    }
}
