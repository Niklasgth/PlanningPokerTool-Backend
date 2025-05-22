package com.timepoker_backend.timepoker_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timepoker_backend.timepoker_backend.DTO.StatsDTO;
import com.timepoker_backend.timepoker_backend.DTO.TaskStatsDTO;
import com.timepoker_backend.timepoker_backend.services.StatsService;

@RestController
@RequestMapping("/api")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/stats/{id}")
    public TaskStatsDTO getStatsByTaskId(@PathVariable String id) {
        return statsService.getStatsByTaskId(id);
    }

    @GetMapping("/stats")
    public StatsDTO getAllStats() {
        return statsService.getAllStats();
    }

}
