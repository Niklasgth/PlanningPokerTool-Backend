package com.timepoker_backend.timepoker_backend.controllers;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.timepoker_backend.timepoker_backend.DTO.CreateTaskDTO;
import com.timepoker_backend.timepoker_backend.models.Task;
import com.timepoker_backend.timepoker_backend.services.TaskService;
import org.springframework.web.bind.annotation.PatchMapping;


@RequestMapping("/api")
@RestController
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/task")
    public Task createTask(@RequestBody @Valid CreateTaskDTO dto) {

        Task task = Task.builder()
                .taskName(dto.getTaskName())
                .taskStory(dto.getTaskStory())
                .taskDuration(0)
                .assignedUserId(null)
                .build();

        return taskService.createTask(task);
    }

@PatchMapping("/task/{id}")
public Task updateTask(@PathVariable String id, @RequestBody Map<String, Object> updates) {
    return taskService.updateTask(id, updates);
}

}
