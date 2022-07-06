package com.web.backend.project.issue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
}
