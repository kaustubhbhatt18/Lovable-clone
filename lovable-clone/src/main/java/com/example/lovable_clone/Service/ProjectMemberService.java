package com.example.lovable_clone.Service;

import com.example.lovable_clone.dto.member.InviteMemberRequest;
import com.example.lovable_clone.dto.member.MemberResponse;
import com.example.lovable_clone.entity.ProjectMember;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {
    List<ProjectMember> getProjectMember(Long projectId, Long userId);

     MemberResponse invitedMember(Long projectId, InviteMemberRequest request, Long userId);

     MemberResponse updateMemberRole(Long projectId, Long memberId, Long userId, InviteMemberRequest request);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
