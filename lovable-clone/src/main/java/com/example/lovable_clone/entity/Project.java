package com.example.lovable_clone.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
@AllArgsConstructor
@Getter

@Setter
@NoArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Table(name="projects",
indexes={
        @Index(name="idx_projects_updated_at_desc",columnList="updated_at DESC,deleted_at"),
        @Index(name="idx_project_deleted_at_updated_at_desc",columnList ="deleted_at,updated_at DESC"),
        @Index(name="idx_project_deleted_at",columnList ="deleted_at")
})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;



    Boolean isPublic = false;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    Instant updatedAt;

    Instant deletedAt;
}
