package com.timepoker_backend.timepoker_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskStatsDTO {
    private String taskId; // not sure if needed? check later
    private int totalEstimates;
    private int averageEstimate;
    //add totalDuration + logic
    // more if needed
}
