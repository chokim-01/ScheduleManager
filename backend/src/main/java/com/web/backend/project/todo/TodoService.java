package com.web.backend.project.todo;

import com.web.backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoDto createTodo(CreateTodoRequest request, Long projectId, User user) {
        Todo todo = Todo.builder().content(request.getContent())
                .title(request.getTitle())
                .status(request.getStatus())
                .time(request.getTime())
                .projectId(request.getProjectId()).build();

        Todo save = todoRepository.save(todo);

        return save.toDto();
    }

    public void updateTodo(Long id , TodoUpdateRequest request, User user){
        Todo todo = todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        if (canNotChangeTodo(todo, user)){
            throw new RuntimeException();
        }

        updateEachFieldIfNotNull(request, todo);

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
