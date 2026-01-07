package com.example.lovable_clone.Service;

import com.example.lovable_clone.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {
     UserProfileResponse getProfile(Long userId);
}
