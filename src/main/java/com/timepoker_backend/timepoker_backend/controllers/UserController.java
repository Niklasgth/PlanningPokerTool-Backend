package com.timepoker_backend.timepoker_backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timepoker_backend.timepoker_backend.DTO.UserLoginDTO;
import com.timepoker_backend.timepoker_backend.DTO.UserRegisterDTO;
import com.timepoker_backend.timepoker_backend.DTO.UserResponseDTO;
import com.timepoker_backend.timepoker_backend.models.User;
import com.timepoker_backend.timepoker_backend.services.UserService;

import jakarta.validation.Valid;

@RequestMapping("/api")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserResponseDTO getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user/register")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRegisterDTO dto) {
        if (userService.getUserByUsername(dto.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        User user = userService.createUser(dto.getUserName(), dto.getUserPassword());
        return ResponseEntity.ok(new UserResponseDTO(user.getId(), user.getUserName()));
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDTO dto) {
        Optional<User> userOpt = userService.getUserByUsername(dto.getUserName());
        if (userOpt.isEmpty() || !userService.checkPassword(dto.getUserPassword(), userOpt.get().getUserPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        User user = userOpt.get();
        return ResponseEntity.ok(new UserResponseDTO(user.getId(), user.getUserName()));
    }

}
