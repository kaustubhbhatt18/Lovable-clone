package com.example.lovable_clone.dto.member;

import com.example.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

import java.lang.reflect.Member;

public record UpdateMemberRoleRequest(
        @NotNull  ProjectRole role) {
}
