package com.timepoker_backend.timepoker_backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timepoker_backend.timepoker_backend.DTO.StatsDTO;
import com.timepoker_backend.timepoker_backend.DTO.TaskStatsDTO;
import com.timepoker_backend.timepoker_backend.models.TaskEstimate;

@Service
public class StatsService {

    @Autowired
    private TaskEstimateService taskEstimateService;

    public TaskStatsDTO getStatsByTaskId(String id) {
        List<TaskEstimate> taskEstimates = taskEstimateService.getEstimatesByTaskId(id);
        List<Integer> filteredEstimates = taskEstimates.stream().map(e -> e.getEstDurationHours())
                .filter(vote -> vote > 0)
                .toList(); // hantera om någon inte röstat - klar

        int totalEstimates = taskEstimates.size(); // antal röster - klar

        if (filteredEstimates.isEmpty()) {
            return new TaskStatsDTO(id, totalEstimates, 0, 0, 0);
        }

        // Medelvärde - klar
        double averageEstimate = 0;
        for (int taskEstimate : filteredEstimates) {
            averageEstimate += taskEstimate;
        }
        averageEstimate = averageEstimate / filteredEstimates.size();

        // standard avvikelser - klar
        double stdDeviation = 0;
        if (filteredEstimates.isEmpty()) {
            stdDeviation = 0;
        } else if (filteredEstimates.size() == 1) {
            stdDeviation = 0;
        } else {
            double sum = 0;
            for (int taskEstimate : filteredEstimates) {
                sum += Math.pow(taskEstimate - averageEstimate, 2);
            }

            stdDeviation = Math.sqrt(sum / filteredEstimates.size());
        }

        // Median - klar
        double median = 0;
        List<Integer> sortedEstimates = filteredEstimates.stream().sorted().toList();
        if (sortedEstimates.size() % 2 == 0) {
            median = (sortedEstimates.get(sortedEstimates.size() / 2)
                    + sortedEstimates.get(sortedEstimates.size() / 2 - 1)) / 2.0;
        } else {
            median = sortedEstimates.get(sortedEstimates.size() / 2);
        }

        return new TaskStatsDTO(id, totalEstimates, averageEstimate, median, stdDeviation);
    }

    public StatsDTO getAllStats() {
        // TODO
        // total amount of tasks
        // total amount of completed tasks
        // average acuracy of estimates
        // average amount of estimates
        // average actual duration of a task
        // etc
        return null;
    }

}
