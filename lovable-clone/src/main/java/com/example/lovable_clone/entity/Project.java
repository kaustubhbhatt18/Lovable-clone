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
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable = false)
    User owner;

    Boolean isPublic = false;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    Instant updatedAt;

    Instant deletedAt;
}
