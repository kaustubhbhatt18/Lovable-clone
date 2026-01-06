package com.example.lovable_clone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
     long id;

    @NotNull(message = "Email can't be Null")
     String email;

    @NotNull(message="Password can't be Empty")
     String password;

    @NotNull(message="Name can't be null")
     String name;

     String avatar_url;

    Instant created_at;

    Instant updated_at;

     Instant deleted_at;
}
