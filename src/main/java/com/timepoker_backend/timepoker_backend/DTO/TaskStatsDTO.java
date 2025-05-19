package com.timepoker_backend.timepoker_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


//handles statistic for a specific task by taskId
@Data
@AllArgsConstructor
public class TaskStatsDTO {
    private String taskId; // not sure if needed? check later
    private int totalEstimates;
    private double averageEstimate;
    private double median;
    private double stdDeviation;
    // add totalDuration + logic <-- not needed?
}
