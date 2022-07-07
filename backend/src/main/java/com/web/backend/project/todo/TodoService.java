package com.web.backend.project.todo;

import com.web.backend.project.ProjectParticipantRepository;
import com.web.backend.user.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final ProjectParticipantRepository participantRepository;

    public TodoDto createTodo(@NotNull CreateTodoRequest request, User user) {
        if(canNotCreateTodo(request.getProjectId(), user)){
            throw new RuntimeException();
        }

        Todo todo = Todo.builder().content(request.getContent())
                .title(request.getTitle())
                .status(request.getStatus())
                .time(request.getTime())
                .user(user)
                .projectId(request.getProjectId()).build();

        Todo save = todoRepository.save(todo);

        return save.toDto();
    }

    private boolean canNotCreateTodo(Long projectId, User user) {
        return !participantRepository.existsByProjectIdAndUserId(projectId, user.getId());
    }

    public TodoDto updateTodo(Long id, TodoUpdateRequest request, User user){
        Todo todo = todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        if (canNotChangeTodo(todo, user)){
            throw new RuntimeException();
        }

        updateEachFieldIfNotNull(request, todo);

        return todo.toDto();
    }

    private boolean canNotChangeTodo(Todo todo, User user) {
        return !todo.getUser().getId().equals(user.getId());
    }

    private void updateEachFieldIfNotNull(TodoUpdateRequest request, Todo todo) {
        if (request.getTitle()!=null){
            todo.setTitle(request.getTitle());
        }
        if (request.getContent()!=null){
            todo.setContent(request.getContent());
        }
        if (request.getTime()!=null){
            todo.setTime(request.getTime());
        }
        if (request.getStatus()!=null){
            todo.setStatus(request.getStatus());
        }
    }


    public void deleteTodo(Long id, User user){
        Todo todo = todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        if (canNotDeleteTodo(todo,user)){
            throw new RuntimeException();
        }

        todoRepository.deleteById(id);

    }

    private boolean canNotDeleteTodo(Todo todo, User user) {
        return !todo.getUser().getId().equals(user.getId());
    }


}
