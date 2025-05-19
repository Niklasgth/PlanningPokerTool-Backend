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
        List<Integer> filteredEstimates = taskEstimates.stream().map(a -> a.getEstDurationHours())
                .filter(vote -> vote > 0)
                .toList(); // hantera om någon inte röstat - klar

        int totalEstimates = taskEstimates.size(); // antal röster - klar

        // Medelvärde - klar
        double averageEstimate = 0;
        for (int taskEstimate : filteredEstimates) {
            averageEstimate += taskEstimate;
        }
        averageEstimate = averageEstimate / filteredEstimates.size();

        // standard avvikelser - WIP
        double sum = 0;
        double stdDeviation = 0;
        for (int taskEstimate : filteredEstimates) {
            sum += Math.pow(taskEstimate - averageEstimate, 2);
        }
        stdDeviation = Math.sqrt(sum / filteredEstimates.size());

        // Median - klar
        double meanValue = 0;
        List<Integer> sortedEstimates = filteredEstimates.stream().sorted().toList();
        if (sortedEstimates.size() % 2 == 0) {
            meanValue = (sortedEstimates.get(sortedEstimates.size() / 2)
                    + sortedEstimates.get(sortedEstimates.size() / 2 - 1)) / 2.0;
        } else {
            meanValue = sortedEstimates.get(sortedEstimates.size() / 2);
        }

        System.out.println("meanValue: " + meanValue);
        System.out.println("totalEstimates: " + totalEstimates);
        System.out.println("filtered Estimates: " + filteredEstimates);
        System.out.println("sortedEstimates: " + sortedEstimates);
        System.out.println("standard Devaiation: " + stdDeviation);
        return new TaskStatsDTO(id, totalEstimates, averageEstimate, meanValue, stdDeviation);
    }

}
