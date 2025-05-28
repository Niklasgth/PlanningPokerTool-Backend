package com.timepoker_backend.timepoker_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

//handles statistic for a specific task by taskId
@Data
@AllArgsConstructor
public class TaskStatsDTO {
    private String taskId;
    private int totalEstimates;
    private double averageEstimate;
    private double median;
    private double stdDeviation;
}
