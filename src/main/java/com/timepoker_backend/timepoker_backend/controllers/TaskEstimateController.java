package com.timepoker_backend.timepoker_backend.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.timepoker_backend.timepoker_backend.models.TaskEstimate;
import com.timepoker_backend.timepoker_backend.services.TaskEstimateService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@RestController
public class TaskEstimateController {

    private TaskEstimateService taskEstimateService;

    public TaskEstimateController(TaskEstimateService taskEstimateService) {
        this.taskEstimateService = taskEstimateService;
    }

    @GetMapping("/taskEstimates")
    public List<TaskEstimate> getTaskEstimates() {
        return taskEstimateService.getTaskEstimates();
    }

    @GetMapping("/taskEstimate/{id}")
    public TaskEstimate getTaskEstimateByID(@PathVariable String id) {
        return taskEstimateService.getTaskEstimateById(id);
    }

    @PostMapping("/taskEstimate")
    public TaskEstimate createTaskEstimate(@RequestBody TaskEstimate taskEstimate) {
        return taskEstimateService.createTaskEstimate(taskEstimate);
    }

}
