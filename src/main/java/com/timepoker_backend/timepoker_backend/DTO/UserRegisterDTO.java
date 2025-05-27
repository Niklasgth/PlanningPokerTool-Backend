package com.timepoker_backend.timepoker_backend.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

//DTO for registering
@Data
@AllArgsConstructor
public class UserRegisterDTO {

    @NotBlank(message = "Username is required")
    private String userName;
    @NotBlank(message = "Password is required")
    private String userPassword;
}
