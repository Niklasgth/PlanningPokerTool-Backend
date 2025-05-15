package com.timepoker_backend.timepoker_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taskEstimates")
public class TaskEstimate {

    @Id
    private String id;
    private String taskId;
    private String userId;
    private int estimatedDurationInHours;

    public TaskEstimate(String id, String taskId, String userId, int estimatedDuration) {
        this.id = id;
        this.taskId = taskId;
        this.userId = userId;
        this.estimatedDurationInHours = estimatedDuration;
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

    public int getEstimatedDurationInHours() {
        return estimatedDurationInHours;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDurationInHours = estimatedDuration;
    }

}
