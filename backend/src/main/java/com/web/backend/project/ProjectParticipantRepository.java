package com.web.backend.project;

import com.web.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ProjectParticipantRepository extends JpaRepository<ProjectParticipant, Long> {

    Set<Long> findParticipantsIdByProjectIdIs(Long projectId);

    boolean existsByProjectIdAndUserId(Long projectId, Long userId);


    boolean existsByUserAndProject(User user, Project project);

    @Query("select p.user from ProjectParticipant p where :project = p.project and p.Role.PARTICIPANT = p.role")
    List<User> findParticipants(Project project);

    @Query("select p.user from ProjectParticipant p where :project = p.project and p.Role.MANAGER = p.role")
    List<User> findManagers(Project project);


    @Query("select count(p) >0 from ProjectParticipant p where :user = p.user and :project = p.project and p.Role.MANAGER = p.role")
    boolean isUserProjectManager(User user, Project project);

}
