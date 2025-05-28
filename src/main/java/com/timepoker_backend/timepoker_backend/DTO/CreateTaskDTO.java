package com.timepoker_backend.timepoker_backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

//DTO for creating a task
@Data
@AllArgsConstructor
public class CreateTaskDTO {

    @NotBlank(message = "Task name is required")
    @Size(max = 25, message = "Task name must be at most 25 characters")
    private String taskName;
    @Size(max = 1000, message = "Task story must be at most 1000 characters")
    private String taskStory;
}
