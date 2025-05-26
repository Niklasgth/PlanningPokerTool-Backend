package com.timepoker_backend.timepoker_backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timepoker_backend.timepoker_backend.DTO.StatsDTO;
import com.timepoker_backend.timepoker_backend.DTO.TaskStatsDTO;
import com.timepoker_backend.timepoker_backend.models.Task;
import com.timepoker_backend.timepoker_backend.models.TaskEstimate;

@Service
public class StatsService {

    @Autowired
    private TaskEstimateService taskEstimateService;

    @Autowired
    private TaskService taskService;

    public double getAverage(List<Integer> values) {
        double sum = 0;
        for (var value : values) {
            sum += value.doubleValue();
        }
        return sum / values.size();
    }

    public TaskStatsDTO getStatsByTaskId(String id) {
        List<TaskEstimate> taskEstimates = taskEstimateService.getEstimatesByTaskId(id);
        List<Integer> filteredEstimates = taskEstimates.stream().map(e -> e.getEstDurationHours())
                .filter(vote -> vote > 0)
                .toList(); // hantera om någon inte röstat - klar

        int totalEstimates = filteredEstimates.size(); //antal röster på filtererade så ej 0 röster är med i .size


        if (filteredEstimates.isEmpty()) {
            return new TaskStatsDTO(id, totalEstimates, 0, 0, 0);
        }

        // Medelvärde - klar
        double averageEstimate = getAverage(filteredEstimates);
        // for (int taskEstimate : filteredEstimates) {
        // averageEstimate += taskEstimate;
        // }
        // averageEstimate = averageEstimate / filteredEstimates.size();

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
        List<Task> tasks = taskService.getTasks();
        List<TaskEstimate> taskEstimates = taskEstimateService.getTaskEstimates();

        List<Integer> taskDurations = taskService.getTasks().stream().map(e -> e.getTaskDuration()).toList();
        List<Integer> taskEstimatesValues = taskEstimates.stream()
                .map(e -> e.getEstDurationHours())
                .filter(vote -> vote > 0)
                .toList();
        // total amount of tasks
        int totalTasks = tasks.size();

        // total amount of completed tasks (tasks with logged time i.e. totalDuration >
        // 0)
        int totalCompletedTasks = (int) tasks.stream()
                .filter(t -> t.getTaskDuration() > 0)
                .count();

        // average acuracy of estimates (compared to actual duration)
        // return a double between 0 and 1
        // (0 = 0% accuracy, 1 = 100% accuracy)
        double avgAccuracy = tasks.stream()
                .mapToDouble(task -> {
                    int taskDuration = task.getTaskDuration();
                    List<Integer> estValues = taskEstimateService.getEstimatesByTaskId(task.getId()).stream()
                            .map(e -> e.getEstDurationHours()).toList();
                    double avgEstimate = getAverage(estValues);
                    return (avgEstimate > 0 && taskDuration > 0)
                            ? Math.min(avgEstimate, taskDuration) / Math.max(avgEstimate, taskDuration)
                            : 0;
                })
                .average().orElse(0);

        // average amount of estimates per task (how many people vote on a task on
        // average)
        double avgEstimateCount = 0;
        if (!tasks.isEmpty()) {
            avgEstimateCount = tasks.stream()
                    .mapToInt(task -> taskEstimateService.getEstimatesByTaskId(task.getId()).size())
                    .average()
                    .orElse(0);
        }

        // average actual duration of a task
        double avgActualDuration = getAverage(taskDurations);

        // average estimate (across all tasks)
        double avgEstimateValue = getAverage(taskEstimatesValues);
        // etc

        return new StatsDTO(totalTasks, totalCompletedTasks, avgAccuracy, avgEstimateCount, avgActualDuration,
                avgEstimateValue);
    }

}
