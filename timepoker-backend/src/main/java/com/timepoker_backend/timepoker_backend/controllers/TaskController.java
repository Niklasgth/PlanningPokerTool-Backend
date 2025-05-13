package com.timepoker_backend.timepoker_backend.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.timepoker_backend.timepoker_backend.models.Task;
import com.timepoker_backend.timepoker_backend.services.TaskService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TaskController {
    
    private TaskService taskService;
    
    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/api/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/api/task/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }
    
    @PostMapping("/api/task")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    
}
