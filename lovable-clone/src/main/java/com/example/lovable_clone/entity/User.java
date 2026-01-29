package com.example.lovable_clone.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "users")   // ✅ VERY IMPORTANT (avoid reserved keyword "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✅ auto-generate ID
    Long id;

    @NotNull(message = "Email can't be null")
    @Column(nullable = false, unique = true)
String username;

//    @NotNull(message = "Password can't be empty")
//    @Column(nullable = false)
   String password;
    @NotNull(message = "Name can't be null")
    @Column(nullable = false)
    String name;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    Instant updatedAt;



    Instant deletedAt;
}
