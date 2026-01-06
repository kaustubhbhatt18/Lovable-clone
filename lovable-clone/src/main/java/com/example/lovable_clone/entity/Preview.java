package com.example.lovable_clone.entity;

import com.example.lovable_clone.enums.PreviewStatue;

import java.time.Instant;

public class Preview {
    Long id;
    Project project;
    String namespace;
    String podName;
    String previewUrl;

    PreviewStatue status;
    Instant startedAt;
    Instant terminatedAt;

    Instant createdAt;
}
