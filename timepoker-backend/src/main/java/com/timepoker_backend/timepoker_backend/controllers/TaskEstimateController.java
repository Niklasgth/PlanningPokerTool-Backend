package com.timepoker_backend.timepoker_backend.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.timepoker_backend.timepoker_backend.models.TaskEstimate;
import com.timepoker_backend.timepoker_backend.services.TaskEstimateService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TaskEstimateController {
    
    private TaskEstimateService taskEstimateService;

    public TaskEstimateController (TaskEstimateService taskEstimateService) {
        this.taskEstimateService = taskEstimateService;
    }

    @GetMapping("/api/taskEstimates")
    public List<TaskEstimate> getTaskEstimates() {
        return taskEstimateService.getTaskEstimates();
    }

    @GetMapping("api/taskEstimate/{id}")
    public TaskEstimate getTaskEstimateByID(@PathVariable String id) {
        return taskEstimateService.getTaskEstimateById(id);
    }
    
    @PostMapping("/api/taskEstimate")
    public TaskEstimate createTaskEstimate(@RequestBody TaskEstimate taskEstimate) {
        return taskEstimateService.createTaskEstimate(taskEstimate);
    }
    
}
