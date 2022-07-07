package com.web.backend.project.issue;

import com.web.backend.project.ProjectParticipantRepository;
import com.web.backend.project.todo.*;
import com.web.backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@Transactional
@RequiredArgsConstructor
public class IssueService {
    private final TodoRepository todoRepository;
    private final IssueRepository issueRepository;
    private final ProjectParticipantRepository participantRepository;

    public IssueDto createTodo(IssueCreateRequest request, User user) {
        validateUserCanCreateTodo(request, user);


        Issue issue = Issue.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .projectId(request.getProjectId())
                .user(user)
                .todoId(request.getTodoId())
                .build();

        Issue save = issueRepository.save(issue);

        return save.toDto();
    }



    public IssueDto updateIssue(Long id, IssueUpdateRequest request, User user) {
        Issue issue = issueRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        validateUserCanUpdateTodo(issue, user);

        updateEachFieldIfNotNull(request, issue);


       return issue.toDto();
    }


    private boolean canNotChangeTodo(Todo todo, User user) {
        return !todo.getUser().getId().equals(user.getId());
    }

    private void updateEachFieldIfNotNull(IssueUpdateRequest request, Issue issue) {
        if (request.getTitle() != null) {
            issue.setTitle(request.getTitle());
        }
        if (request.getContent() != null) {
            issue.setContent(request.getContent());
        }
    }


    private void validateUserCanUpdateTodo(Issue issue,@NotNull User user) {
        if (issue.getUser().getId()!=user.getId()){
            throw new RuntimeException();
        }
    }

    private void validateUserCanCreateTodo(IssueCreateRequest request, User user) {
        if (userIsNotProjectParticipant(request.getProjectId(), user)) {
            throw new RuntimeException();
        }
        if (todoIsNotInProject(request.getTodoId(), request.getProjectId())) {
            throw new RuntimeException();
        }
    }

    private boolean todoIsNotInProject(Long todoId,Long projectId) {
        if (todoId != null) {
            Todo todo = todoRepository.findById(todoId).orElseThrow(IllegalArgumentException::new);
            if (!todo.getProjectId().equals(todoId)) {
                return false;
            }
        }
        return true;
    }
    private boolean userIsNotProjectParticipant(Long projectId, User user) {
        return participantRepository.existsByProjectIdAndUserId(projectId, user.getId());
    }

}
