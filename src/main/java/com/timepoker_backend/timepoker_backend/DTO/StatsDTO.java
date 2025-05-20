package com.timepoker_backend.timepoker_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

//handles general statistics for all tasks together
@Data
@AllArgsConstructor
public class StatsDTO {

    private int totalTasks;
    private int totalCompletedTasks;
    private double avgAccuracy;
    private double avgEstimate;
    private double avgActualDuration;

}
