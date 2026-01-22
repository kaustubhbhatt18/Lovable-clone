package com.example.lovable_clone.mapper;

import com.example.lovable_clone.dto.member.MemberResponse;
import com.example.lovable_clone.entity.ProjectMember;
import org.apache.catalina.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
