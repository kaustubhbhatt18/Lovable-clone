package com.example.lovable_clone.Service.impl;

import com.example.lovable_clone.Service.ProjectService;
import com.example.lovable_clone.dto.project.ProjectRequest;
import com.example.lovable_clone.dto.project.ProjectResponse;
import com.example.lovable_clone.dto.project.ProjectSummaryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectsById(Long id, Long userid) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softdelete(Long id, Long userId) {

    }
}
