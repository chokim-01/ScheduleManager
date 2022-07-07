package com.web.backend.project;

import com.web.backend.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.parameters.P;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {
    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectParticipantRepository participantRepository;

    @InjectMocks
    ProjectService projectService;

    @Test
    void createProject() {
        ProjectCreateRequest request = new ProjectCreateRequest();
        request.setName("name");
        request.setDescription("projectDescription");
        request.setPublicOption(true);
        request.setStartTime(LocalDateTime.of(2022,1,1,1,1));
        request.setEndTime(LocalDateTime.of(2022,1,1,1,1));

        User user = User.builder().userId("jaegon").build();
        when(projectRepository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        ProjectDto returnDto = projectService.createProject(request, user);

        assertThat(returnDto.getName()).isEqualTo(request.getName());
        assertThat(returnDto.getDescription()).isEqualTo(request.getDescription());
        assertThat(returnDto.isPublicOption()).isEqualTo(request.isPublicOption());
        assertThat(returnDto.getStartTime()).isEqualTo(request.getStartTime());
        assertThat(returnDto.getEndTime()).isEqualTo(request.getEndTime());
        assertThat(returnDto.getManagers().size()).isEqualTo(1);
        assertThat(returnDto.getManagers().get(0).getUserId()).isEqualTo("jaegon");
        assertThat(returnDto.getParticipants()).isNull();

    }

    @Test
    void updateProject() {
        User user = User.builder().build();
        ReflectionTestUtils.setField(user,"id",1L);

        Project project = Project.builder()
                .name("testName")
                .description("testDescription")
                .startTime(LocalDateTime.of(2022,7,7,7,7))
                .endTime(LocalDateTime.of(2022,7,7,7,7))
                .publicOption(true)
                .build();

        ProjectUpdateRequest request = new ProjectUpdateRequest();
        request.setName("updateName");
        request.setDescription("updateDescription");
        request.setStartTime(LocalDateTime.of(2022,8,8,8,8));
        request.setEndTime(LocalDateTime.of(2022,8,8,8,8));
        request.setPublicOption(false);
        when(projectRepository.findById(any())).thenReturn(Optional.ofNullable(project));
        when(participantRepository.isUserProjectManager(any(),any())).thenReturn(true);

        ProjectDto projectDto = projectService.updateProject(1L, request, user);

        assertThat(projectDto.getName()).isEqualTo(request.getName());
        assertThat(projectDto.getDescription()).isEqualTo(request.getDescription());
        assertThat(projectDto.isPublicOption()).isEqualTo(request.getPublicOption());
        assertThat(projectDto.getStartTime()).isEqualTo(request.getStartTime());
        assertThat(projectDto.getEndTime()).isEqualTo(request.getEndTime());


    }
}