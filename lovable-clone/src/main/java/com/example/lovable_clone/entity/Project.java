package com.example.lovable_clone.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Project {
    Long id;

    String name;

    User owner;
    Boolean isPublic=false;

    Instant created_at;
    Instant updated_at;
    Instant deleted_at;
}
