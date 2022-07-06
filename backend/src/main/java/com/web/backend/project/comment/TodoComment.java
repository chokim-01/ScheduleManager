package com.web.backend.project.comment;

import com.web.backend.project.todo.Todo;
import com.web.backend.user.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoComment{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private String content;

    @CreatedDate
    private LocalDateTime commentedAt;

    @ManyToOne
    private Todo todo;

    @Builder
    public TodoComment(User user, String content, Todo todo) {
        this.user = user;
        this.content = content;
        this.todo = todo;
        this.commentedAt = LocalDateTime.now();
    }
}
