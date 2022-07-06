package com.web.backend.project.comment;


import com.web.backend.project.issue.Issue;
import com.web.backend.project.todo.Todo;
import com.web.backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final TodoCommentRepository todoCommentRepository;
    private final IssueCommentRepository issueCommentRepository;

    public IssueComment CreateIssueComment(Issue issue, String content, User user) {
        IssueComment comment = IssueComment.builder().issue(issue).content(content).user(user).build();

        return issueCommentRepository.save(comment);
    }

    public TodoComment createTodoComment(Todo todo, String content, User user) {
        TodoComment comment = TodoComment.builder().todo(todo).content(content).user(user).build();
        return todoCommentRepository.save(comment);
    }
}
