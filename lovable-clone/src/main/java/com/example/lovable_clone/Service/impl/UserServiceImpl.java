package com.example.lovable_clone.Service.impl;

import com.example.lovable_clone.Service.UserService;
import com.example.lovable_clone.dto.auth.UserProfileResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
