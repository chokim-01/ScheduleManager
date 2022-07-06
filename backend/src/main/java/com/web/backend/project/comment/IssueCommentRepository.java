package com.web.backend.project.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueCommentRepository extends JpaRepository<IssueComment,Long> {
}
