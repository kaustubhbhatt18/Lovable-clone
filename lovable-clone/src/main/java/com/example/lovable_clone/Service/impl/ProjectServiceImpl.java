package com.example.lovable_clone.Service.impl;

import com.example.lovable_clone.Service.ProjectService;
import com.example.lovable_clone.dto.project.ProjectRequest;
import com.example.lovable_clone.dto.project.ProjectResponse;
import com.example.lovable_clone.dto.project.ProjectSummaryResponse;
import com.example.lovable_clone.entity.Project;
import com.example.lovable_clone.entity.ProjectMember;
import com.example.lovable_clone.entity.ProjectMemberId;
import com.example.lovable_clone.entity.User;
import com.example.lovable_clone.enums.ProjectRole;
import com.example.lovable_clone.error.ResourceNotFoundException;
import com.example.lovable_clone.mapper.ProjectMapper;
import com.example.lovable_clone.repository.ProjectMemberRepository;
import com.example.lovable_clone.repository.ProjectRepository;
import com.example.lovable_clone.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;



@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
@Service
@Transactional

public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", userId.toString())
        );

        // 1. Create and SAVE project first
        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);   // ✅ REQUIRED

        // 2. Now create membership
        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());

        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(owner)
                .projectRole(ProjectRole.OWNER)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
    }


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream().map(projectMapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project =  getAccessibleProjectById(id,userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project = getAccessibleProjectById(id,userId);
        project.setName(request.name());

//        project = projectRepository.save(project); as i am using @Transactional no need to save
        return projectMapper.toProjectResponse(project);
    }


    @Override
    public void softdelete(Long id, Long userId) {
    Project project = getAccessibleProjectById(id,userId);

    project.setDeletedAt(Instant.now());
    projectRepository.save(project);
    }


    // INTERNAL FUNCTIONS
    public Project getAccessibleProjectById(Long projectId,Long UserId){
        return projectRepository.findAccessibleProjectById(projectId,UserId).orElseThrow(()->new ResourceNotFoundException("Project",projectId.toString()));
    }
}
