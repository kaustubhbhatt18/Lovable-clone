package com.example.lovable_clone.Service.impl;

import com.example.lovable_clone.Service.ProjectService;
import com.example.lovable_clone.dto.project.ProjectRequest;
import com.example.lovable_clone.dto.project.ProjectResponse;
import com.example.lovable_clone.dto.project.ProjectSummaryResponse;
import com.example.lovable_clone.entity.Project;
import com.example.lovable_clone.entity.User;
import com.example.lovable_clone.mapper.ProjectMapper;
import com.example.lovable_clone.repository.ProjectRepository;
import com.example.lovable_clone.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;



@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
@Service
@Transactional

public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;


    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project
                .builder()
                .name(request.name())
                .build();
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }



    @Override
    public ProjectResponse getUserProjectsById(Long id, Long userid) {
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
