package com.web.backend.project.todo;

import com.web.backend.project.ProjectParticipantRepository;
import com.web.backend.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;


import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE_TIME;
import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
    @Mock
    ProjectParticipantRepository participantRepository;
    @Mock
    TodoRepository todoRepository;
    @InjectMocks
    TodoService todoService;

    @Test
    @DisplayName("Todo 생성 성공 테스트")
    void createTodo() {
        CreateTodoRequest request = new CreateTodoRequest();
        request.setTitle("testTitle");
        request.setContent("testContent");
        request.setProjectId(1L);
        request.setStatus(Todo.Status.TODO);
        request.setTime(LocalDateTime.now());
        User user = User.builder()
                .userId("testUser")
                .encryptedPassword("password")
                .nickname("jaegon")
                .email("email").build();
        when(todoRepository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());
        when(participantRepository.existsByProjectIdAndUserId(any(),any())).thenReturn(true);

        TodoDto todo = todoService.createTodo(request, user);

        assertThat(todo.getContent()).isEqualTo(request.getContent());
        assertThat(todo.getTitle()).isEqualTo(request.getTitle());
        assertThat(todo.getUser()).isEqualTo(user);
        assertThat(todo.getStatus()).isEqualTo(request.getStatus());
        assertThat(todo.getProjectId()).isEqualTo(request.getProjectId());

    }

    @Test
    @DisplayName("update 성공 테스트")
    void updateTodo() {

        LocalDateTime requestTime = LocalDateTime.of(2022,10,11,11,11);
        TodoUpdateRequest request = new TodoUpdateRequest();
        request.setTitle("updateTitle");
        request.setContent("updateContents");
        request.setStatus(Todo.Status.DONE);
        request.setTime(requestTime);
        User user = User.builder().build();
        ReflectionTestUtils.setField(user,"id",1L);

        Todo todo = Todo.builder()
                .title("testTitle")
                .projectId(1L)
                .user(user)
                .content("testContent")
                .status(Todo.Status.IN_PROGRESS)
                .time(LocalDateTime.of(2022,10,10,10,10)).build();

        when(todoRepository.findById(any())).thenReturn(Optional.ofNullable(todo));

        TodoDto updateDto = todoService.updateTodo(1L, request, user);

        assertThat(updateDto.getTitle()).isEqualTo(request.getTitle());
        assertThat(updateDto.getContent()).isEqualTo(request.getContent());
        assertThat(updateDto.getStatus()).isEqualTo(request.getStatus());
        assertThat(updateDto.getTime()).isEqualTo(request.getTime());

    }

}