package com.example.lovable_clone.mapper;

import com.example.lovable_clone.dto.member.MemberResponse;
import com.example.lovable_clone.entity.ProjectMember;
import com.example.lovable_clone.entity.User;   // ✅ CORRECT USER
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    @Mapping(target="userId",source="id")
    @Mapping(target="projectRole",constant="OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target="email",source="user.email")
    @Mapping(target="name",source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
