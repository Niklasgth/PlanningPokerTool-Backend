package com.timepoker_backend.timepoker_backend.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.timepoker_backend.timepoker_backend.models.Task;
import com.timepoker_backend.timepoker_backend.repositories.TaskRepository;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(String id) {
        Optional<Task> task = taskRepository.findById(id);
    
            if (task.isPresent()) {
                return task.get();
            } else {
                return null;
            }
    }
    
}
