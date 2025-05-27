package com.timepoker_backend.timepoker_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

//DTO for returning user information (currently used only on register)
@Data
@AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String userName;
}
