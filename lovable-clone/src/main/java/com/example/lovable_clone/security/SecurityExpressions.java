package com.example.lovable_clone.security;

import com.example.lovable_clone.enums.ProjectRole;
import com.example.lovable_clone.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor

public class SecurityExpressions {
    private final AuthUtil authUtil;
    private final ProjectMemberRepository projectMemberRepository;

    public boolean canViewProject(Long projectId){
        Long userId = authUtil.getCurrentUserId();

     return    projectMemberRepository.findRoleByProjectIdAndUserId(projectId,userId)
             .map(role->
                     role.equals(ProjectRole.OWNER)||role.equals(ProjectRole.VIEWER)|| role.equals(ProjectRole.EDITOR))
             .orElse(false);

    }

    public boolean canEditProject(Long projectId){
Long userId = authUtil.getCurrentUserId();

return projectMemberRepository
        .findRoleByProjectIdAndUserId(projectId,userId)
        .map(role ->
                role.equals(ProjectRole.EDITOR)||role.equals(ProjectRole.OWNER))
        .orElse(false);
    }

}
