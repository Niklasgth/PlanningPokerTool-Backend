package com.timepoker_backend.timepoker_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "taskEstimates")
public class TaskEstimate {

    @Id
    private String id;
    private String taskId;
    private String userId;
    private int estDurationHours;
    

}
