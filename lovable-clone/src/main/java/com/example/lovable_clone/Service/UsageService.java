package com.example.lovable_clone.Service;

import com.example.lovable_clone.dto.subscription.PlanLimitResponse;
import com.example.lovable_clone.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
     UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
