package com.example.lovable_clone.dto.auth;

public record AuthResponse(Long id,
        String username,
        String token,
        UserProfileResponse user) {

}
