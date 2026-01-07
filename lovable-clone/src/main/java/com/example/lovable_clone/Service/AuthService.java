package com.example.lovable_clone.Service;

import com.example.lovable_clone.dto.auth.AuthResponse;
import com.example.lovable_clone.dto.auth.LoginRequest;
import com.example.lovable_clone.dto.auth.SignupRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {

     AuthResponse signup(SignupRequest request);

     AuthResponse login(LoginRequest request);
}
