package com.web.backend.project;


import com.web.backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectParticipantRepository participantRepository;


    public ProjectDto createProject(ProjectCreateRequest request, User user) {
        Project project = Project.builder()
                .name(request.getName())
                .description(request.getName())
                .description(request.getDescription())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime()).build();


        Project saved = projectRepository.save(project);

        addUserToProjectManager(saved, user);
        ProjectDto projectDto = saved.toDto();
        projectDto.getManagers().add(user.toDto());

        return projectDto;
    }

    private void addUserToProjectManager(Project project, User user) {
        participantRepository.save(new ProjectParticipant(project, user, ProjectParticipant.Role.MANAGER));

    }

    public void updateProject(Long id, ProjectUpdateRequest request, User user) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("project not exist"));

        if (isUserNotProjectManager(user, project)) {
            throw new AccessDeniedException("user has no authority");
        }

        updateProjectFromRequest(project, request);

    }
    private void updateProjectFromRequest(Project project, ProjectUpdateRequest request){
        if (request.getName() != null) {
            project.setName(request.getName());
        }
        if (request.getDescription() != null) {
            project.setDescription(request.getDescription());
        }
        if (request.getPublicOption() != null) {
            project.setPublicOption(request.getPublicOption());
        }
        if (request.getStartTime() != null) {
            project.setStartTime(request.getStartTime());
        }
        if (request.getStartTime() != null) {
            project.setEndTime(request.getEndTime());
        }
    }

    public void deleteProject(Long id, User user) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("project not exist"));

        if (isUserNotProjectManager(user, project)) {
            throw new AccessDeniedException("user has no authority");
        }

        projectRepository.delete(project);
    }


    private boolean isUserNotProjectManager(User user, Project project){
        return !isUserProjectManager(user, project);
    }
    private boolean isUserProjectManager(User user, Project project) {
        return participantRepository.isUserProjectManager(user, project);
    }

    public ProjectDto showProjectDetail(Long id, User user) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("project not exist"));

        if (userCanNotAccessProject(user, project)){
            throw new AccessDeniedException("user has no authority");
        }

        ProjectDto projectDto = project.toDto();
        projectDto.setManagers(participantRepository.findManagers(project).stream().map(User::toDto).collect(Collectors.toList()));
        projectDto.setParticipants(participantRepository.findParticipants(project).stream().map(User::toDto).collect(Collectors.toList()));

        return projectDto;
    }

    private boolean userCanNotAccessProject(User user, Project project) {
        return participantRepository.existsByUserAndProject(user,project)&&project.isPublicOption();
    }


}
