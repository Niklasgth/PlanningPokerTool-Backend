package com.timepoker_backend.timepoker_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taskEstimates")
public class TaskEstimate {
    
    @Id
    private String id;
    private String taskId;
    private String userId;
    private long estimatedDuration;

    public TaskEstimate(String id, String taskId, String userId, long estimatedDuration) {
        this.id = id;
        this.taskId = taskId;
        this.userId = userId;
        this.estimatedDuration = estimatedDuration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(long estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    
}
