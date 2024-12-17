package com.rabiloo.issue_logging.services.impl;

import com.rabiloo.issue_logging.DTO.Project.ProjectCreateRequestDTO;
import com.rabiloo.issue_logging.domain.Project;
import com.rabiloo.issue_logging.repositories.ProjectRepository;
import com.rabiloo.issue_logging.services.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(ProjectCreateRequestDTO dto) {

        return null;
    }

    @Override
    public Project updateProject(int id, ProjectCreateRequestDTO dto) {
        return null;
    }

    @Override
    public boolean deleteProject(int id) {
        return false;
    }

    @Override
    public Project getProject(int id) {
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return null;
    }
}
