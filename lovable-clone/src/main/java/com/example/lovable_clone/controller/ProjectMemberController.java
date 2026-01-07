package com.example.lovable_clone.controller;

import com.example.lovable_clone.Service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {
private final ProjectMemberService projectMemberService;


}
