package com.timepoker_backend.timepoker_backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.timepoker_backend.timepoker_backend.models.TaskEstimate;
import com.timepoker_backend.timepoker_backend.repositories.TaskEstimateRepository;

@Service
public class TaskEstimateService {

    private TaskEstimateRepository taskEstimateRepository;

    public TaskEstimateService(TaskEstimateRepository taskEstimateRepository) {
        this.taskEstimateRepository = taskEstimateRepository;
    }

    public List<TaskEstimate> getTaskEstimates() {
        return taskEstimateRepository.findAll();
    }

    public TaskEstimate createTaskEstimate(TaskEstimate taskEstimate) {
        if (taskEstimate.getEstDurationHours() < 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        return taskEstimateRepository.save(taskEstimate);
    }

    public TaskEstimate getTaskEstimateById(String id) {
        Optional<TaskEstimate> taskEstimate = taskEstimateRepository.findById(id);
        return taskEstimate
                .orElseThrow(() -> new NullPointerException("Task Estimate with id " + id + " not found"));
    }

    public List<TaskEstimate> getEstimatesByTaskId(String id) {
        return taskEstimateRepository.findByTaskId(id);
    }

}
