package com.web.backend.project;

import com.web.backend.user.CurrentUser;
import com.web.backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;



    @GetMapping("/project/{id}")
    public ResponseEntity<ProjectDto> projectDetails(@PathVariable Long id, @CurrentUser User user){

        return ResponseEntity.ok(projectService.showProjectDetail(id, user));
    }

    @PostMapping("/project")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectCreateRequest request, @CurrentUser User user){

        ProjectDto projectDto = projectService.createProject(request, user);

        return ResponseEntity.status(HttpStatus.CREATED).body(projectDto);
    }

    @PutMapping("/project/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable Long id, @RequestBody ProjectUpdateRequest request, @CurrentUser User user ){

        projectService.updateProject(id, request,user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/project/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long id, @CurrentUser User user ){
        projectService.deleteProject(id,user);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }






}
