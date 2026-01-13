package com.example.lovable_clone.Service.impl;

import com.example.lovable_clone.Service.UsageService;
import com.example.lovable_clone.dto.subscription.PlanLimitResponse;
import com.example.lovable_clone.dto.subscription.UsageTodayResponse;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
