package com.example.backend.controller;

import com.example.backend.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(
            DashboardService dashboardService) {

        this.dashboardService = dashboardService;
    }

    @GetMapping
    public Map<String, Long> getDashboard() {
        return dashboardService
                .getDashboardData();
    }
}