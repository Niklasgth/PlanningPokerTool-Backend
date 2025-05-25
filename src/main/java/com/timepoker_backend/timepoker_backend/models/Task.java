package com.timepoker_backend.timepoker_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "tasks")
@Builder
public class Task {

    @Id
    private String id;
    private String taskName;
    private String taskStory;
    private int taskDuration;
    private String assignedUserId;

}
