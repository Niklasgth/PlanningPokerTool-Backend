package com.timepoker_backend.timepoker_backend.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String userId;
    private String userName;
}
