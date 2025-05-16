package com.timepoker_backend.timepoker_backend.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;

@Document(collection = "tasks")
@Builder
public class Task {

    @Id
    private String id;
    private String taskName;
    private String taskStory;
    private long taskDuration;
    private String assignedUserId;

    public Task(String id, String taskName, String taskStory, long taskDuration, String assignedUserId) {
        this.id = id;
        this.taskName = taskName;
        this.taskStory = taskStory;
        this.taskDuration = taskDuration;
        this.assignedUserId = assignedUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStory() {
        return taskStory;
    }

    public void setTaskStory(String taskStory) {
        this.taskStory = taskStory;
    }

    public long getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(long taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

}
