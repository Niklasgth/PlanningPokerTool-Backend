package com.timepoker_backend.timepoker_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timepoker_backend.timepoker_backend.DTO.TaskStatsDTO;
import com.timepoker_backend.timepoker_backend.models.TaskEstimate;
import com.timepoker_backend.timepoker_backend.services.StatsService;
import com.timepoker_backend.timepoker_backend.services.TaskEstimateService;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    // @Autowired
    // private TaskEstimateService taskEstimateService;

    @GetMapping("/{id}")
    public TaskStatsDTO getStatsByTaskId(@PathVariable String id) {

        // List<TaskEstimate> taskEstimates =
        // taskEstimateService.getEstimatesByTaskId(id);

        return statsService.getStatsByTaskId(id);
    }

}
