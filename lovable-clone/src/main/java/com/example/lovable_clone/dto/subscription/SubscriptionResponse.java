package com.example.lovable_clone.dto.subscription;

import java.time.Instant;

public record SubscriptionResponse(PlanResponse plan, Long tokenUsedThisCycle, String status, Instant period) {
}
