package com.example.lovable_clone.Service.impl;

import com.example.lovable_clone.dto.member.InviteMemberRequest;
import com.example.lovable_clone.dto.member.MemberResponse;
import com.example.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.example.lovable_clone.entity.Project;
import com.example.lovable_clone.mapper.ProjectMemberMapper;
import com.example.lovable_clone.repository.ProjectMemberRepository;
import com.example.lovable_clone.repository.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ProjectMemberServiceImpl implements com.example.lovable_clone.Service.ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    @Override
    public List<MemberResponse> getProjectMember(Long projectId, Long userId) {
Project project = getAccessibleProjectById(projectId,userId);

List<MemberResponse> memberResponsesList = new ArrayList<>();

memberResponsesList.add(projectMemberMapper.toProjectMemberResponseFromOwner((User) project.getOwner()));

memberResponsesList.addAll(
projectMemberRepository.findByIdProjectId(projectId).stream().map(projectMemberMapper::toProjectMemberResponseFromMember).toList());
return memberResponsesList;
    }

    @Override
    public MemberResponse invitedMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, Long userId, UpdateMemberRoleRequest request) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }


    public Project getAccessibleProjectById(Long projectId, Long UserId){
        return projectRepository.findAccessibleProjectById(projectId,UserId).orElseThrow();
    }
}
