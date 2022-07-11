package com.web.backend.project.comment;

import com.web.backend.project.issue.Issue;
import com.web.backend.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IssueComment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String content;

    @CreatedDate
    private LocalDateTime commentedAt;

    @ManyToOne
    private Issue issue;

    @Builder
    public IssueComment(User user, String content, Issue issue) {
        this.user = user;
        this.content = content;
        this.issue = issue;
        this.commentedAt = LocalDateTime.now();
    }
}
