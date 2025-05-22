package com.timepoker_backend.timepoker_backend.services;
import java.util.List;
import java.util.Map;
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
    
    public Task updateTask(String id, Map<String, Object> updates) {
    Task task = getTaskById(id);
    if (task == null) {
        throw new RuntimeException("Task med id " + id + " hittades inte.");
    }

    if (updates.containsKey("taskDuration")) {
        Object durationObj = updates.get("taskDuration");
        if (durationObj instanceof Number) {
            task.setTaskDuration(((Number) durationObj).intValue());
        }
    }

    return taskRepository.save(task);
}
}






