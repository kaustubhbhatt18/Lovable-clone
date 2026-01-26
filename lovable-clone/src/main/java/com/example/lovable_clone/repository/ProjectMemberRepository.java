package com.example.lovable_clone.repository;

import com.example.lovable_clone.entity.ProjectMember;
import com.example.lovable_clone.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

    // ✅ NEW: checks if a user is already a member of a project
    boolean existsByIdProjectIdAndIdUserId(Long projectId, Long userId);
}
