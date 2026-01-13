package com.example.lovable_clone.controller;

import com.example.lovable_clone.Service.FileService;
import com.example.lovable_clone.dto.project.FileContentResponse;
import com.example.lovable_clone.dto.project.FileNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    // Get file tree
    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId, userId));
    }

    // Get file content
    @GetMapping("/content")
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @RequestParam String path
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId, path, userId));
    }
}
