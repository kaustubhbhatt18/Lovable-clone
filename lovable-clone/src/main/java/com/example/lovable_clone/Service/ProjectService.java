package com.example.lovable_clone.Service;

import com.example.lovable_clone.dto.project.ProjectRequest;
import com.example.lovable_clone.dto.project.ProjectResponse;
import com.example.lovable_clone.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse getUserProjectsById(Long id, Long userid);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);

    void softdelete(Long id, Long userId);
}
