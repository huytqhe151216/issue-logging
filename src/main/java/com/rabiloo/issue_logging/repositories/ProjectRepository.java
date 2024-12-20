package com.rabiloo.issue_logging.repositories;

import com.rabiloo.issue_logging.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Optional<Project> findById(int id);
}
