package com.timepoker_backend.timepoker_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskStatsDTO {
    private String taskId; // not sure if needed? check later
    private int totalEstimates;
    private double averageEstimate;
    private double meanValue;
    private double stdDeviation;
    // add totalDuration + logic
    // more if needed
}
