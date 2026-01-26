package com.example.lovable_clone.Service.impl;

import com.example.lovable_clone.Service.ProjectMemberService;
import com.example.lovable_clone.dto.member.InviteMemberRequest;
import com.example.lovable_clone.dto.member.MemberResponse;
import com.example.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.example.lovable_clone.entity.Project;
import com.example.lovable_clone.entity.ProjectMember;
import com.example.lovable_clone.entity.ProjectMemberId;
import com.example.lovable_clone.entity.User;
import com.example.lovable_clone.mapper.ProjectMemberMapper;
import com.example.lovable_clone.repository.ProjectMemberRepository;
import com.example.lovable_clone.repository.ProjectRepository;
import com.example.lovable_clone.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMember(Long projectId, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);

        List<MemberResponse> memberResponsesList = new ArrayList<>();

        // Add owner
        memberResponsesList.add(
                projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner())
        );

        // Add members
        memberResponsesList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList()
        );

        return memberResponsesList;
    }

    @Override
    public MemberResponse invitedMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        // Only owner can invite
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not allowed");
        }

        // Find user by email
        User invitee = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Cannot invite yourself
        if (invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself");
        }

        // ✅ CORRECT CHECK: is user already member?
        if (projectMemberRepository.existsByIdProjectIdAndIdUserId(projectId, invitee.getId())) {
            throw new RuntimeException("User already invited");
        }

        // Create new member
        ProjectMember member = ProjectMember.builder()
                .id(new ProjectMemberId(projectId, invitee.getId()))
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, Long userId, UpdateMemberRoleRequest request) {
        Project project = getAccessibleProjectById(projectId, userId);

        // Only owner can invite
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not allowed");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();
    projectMember.setProjectRole(request.role());
    projectMemberRepository.save(projectMember);
    return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
        }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        // Only owner can invite
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not allowed");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepository.deleteById(projectMemberId);

    }


    /// INTERNAL FUNCTION
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new RuntimeException("Project not found or no access"));
    }
}
