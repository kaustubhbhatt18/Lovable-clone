package com.example.lovable_clone.Service;

import com.example.lovable_clone.dto.project.FileContentResponse;
import com.example.lovable_clone.dto.project.FileNode;

import java.util.List;
import java.util.Optional;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
