package com.rabiloo.issue_logging.services;

import com.rabiloo.issue_logging.DTO.Project.ProjectCreateRequestDTO;
import com.rabiloo.issue_logging.domain.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(ProjectCreateRequestDTO dto);

    Project updateProject(int id, ProjectCreateRequestDTO dto);

    boolean deleteProject(int id);

    Project getProject(int id);

    List<Project> getAllProjects();
}
