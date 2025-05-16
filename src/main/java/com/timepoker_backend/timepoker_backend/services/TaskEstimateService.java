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
        return taskEstimateRepository.save(taskEstimate);
    }

    public TaskEstimate getTaskEstimateById(String id) {
        Optional<TaskEstimate> taskEstimate = taskEstimateRepository.findById(id);

        if (taskEstimate.isPresent()) {
            return taskEstimate.get();
        } else {
            return null;
        }
    }

    public List<TaskEstimate> getEstimatesByTaskId(String id) {
        return taskEstimateRepository.findByTaskId(id);
    }

}
