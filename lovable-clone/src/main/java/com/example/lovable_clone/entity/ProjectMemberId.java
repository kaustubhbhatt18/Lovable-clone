package com.example.lovable_clone.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ProjectMemberId {
    Long projectId;
    Long  userId;
}
