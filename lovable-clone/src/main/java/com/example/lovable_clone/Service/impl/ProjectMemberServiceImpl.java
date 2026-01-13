package com.example.lovable_clone.Service.impl;

import com.example.lovable_clone.dto.member.InviteMemberRequest;
import com.example.lovable_clone.dto.member.MemberResponse;
import com.example.lovable_clone.dto.member.UpdateMemberRoleRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectMemberServiceImpl implements com.example.lovable_clone.Service.ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMember(Long projectId, Long userId) {
        return List.of();
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
}
