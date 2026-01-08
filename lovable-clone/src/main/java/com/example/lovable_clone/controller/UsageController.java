package com.example.lovable_clone.controller;

import com.example.lovable_clone.Service.UsageService;
import com.example.lovable_clone.dto.subscription.PlanLimitResponse;
import com.example.lovable_clone.dto.subscription.UsageTodayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {
    private final UsageService usageService;
    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse>getTodayUsage(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }
    @GetMapping("/Limits")
    public ResponseEntity<PlanLimitResponse>getPlantLimit(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitsOfUser(userId));
    }
}
