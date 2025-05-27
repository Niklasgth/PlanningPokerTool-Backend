package com.timepoker_backend.timepoker_backend.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.timepoker_backend.timepoker_backend.DTO.UserResponseDTO;
import com.timepoker_backend.timepoker_backend.models.User;
import com.timepoker_backend.timepoker_backend.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getUserName()))
                .toList();
    }

    public User createUser(String userName, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = new User(null, userName, encodedPassword);
        return userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    public UserResponseDTO getUserById(String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return new UserResponseDTO(id, user.get().getUserName());
        } else {
            return null;
        }
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
