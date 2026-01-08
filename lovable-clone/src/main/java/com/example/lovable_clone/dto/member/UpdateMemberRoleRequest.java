package com.example.lovable_clone.dto.member;

import com.example.lovable_clone.enums.ProjectRole;

import java.lang.reflect.Member;

public record UpdateMemberRoleRequest(ProjectRole role) {
}
