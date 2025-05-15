package com.timepoker_backend.timepoker_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timepoker_backend.timepoker_backend.DTO.TaskStatsDTO;
import com.timepoker_backend.timepoker_backend.models.TaskEstimate;

@Service
public class StatsService {

    @Autowired
    private TaskEstimateService taskEstimateService;

    public TaskStatsDTO getStatsByTaskId(String id) {
        List<TaskEstimate> taskEstimates = taskEstimateService.getEstimatesByTaskId(id);

        int totalEstimates = taskEstimates.size();
        int averageEstimate = 0;
        for (TaskEstimate taskEstimate : taskEstimates) {
            averageEstimate += taskEstimate.getEstimatedDurationInHours();
        }
        averageEstimate = averageEstimate / totalEstimates;

        return new TaskStatsDTO(id, totalEstimates, averageEstimate);
    }

}
