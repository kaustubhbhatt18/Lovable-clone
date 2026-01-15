package com.example.lovable_clone.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
@AllArgsConstructor
@Getter
@Entity
@Setter
@NoArgsConstructor
@Builder
@Table(name="projects")
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Project {
   @Id
           @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   @Column(nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name="owner_id",nullable = false)
    User owner;
    Boolean isPublic=false;
    @CreationTimestamp
    Instant created_at;
    @UpdateTimestamp
    Instant updated_at;
    Instant deleted_at;
}
