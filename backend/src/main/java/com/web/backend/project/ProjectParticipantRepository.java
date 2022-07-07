package com.web.backend.project;

import com.web.backend.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public interface ProjectParticipantRepository extends JpaRepository<ProjectParticipant, Long> {

    Set<Long> findParticipantsIdByProjectIdIs(Long projectId);

    boolean existsByProjectIdAndUserId(Long projectId, Long userId);


    boolean existsByUserAndProject(User user, Project project);



    @Query("select p.user from ProjectParticipant p where p.project = :project and p.role = 'MANAGER'")
    List<User> findManagers(Project project);

    @Query("select p.user from ProjectParticipant p where p.project = :project and p.role = 'PARTICIPANT'")
    List<User> findParticipants(Project project);


    @Query(value = "select count(p) >0 from ProjectParticipant p where :user = p.user and :project = p.project and 'MANAGER' = p.role")
    boolean isUserProjectManager(User user, Project project);


}
