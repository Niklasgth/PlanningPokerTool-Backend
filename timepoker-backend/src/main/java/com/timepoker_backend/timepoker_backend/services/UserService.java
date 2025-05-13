package com.timepoker_backend.timepoker_backend.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.timepoker_backend.timepoker_backend.models.User;
import com.timepoker_backend.timepoker_backend.repositories.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
    
            if (user.isPresent()) {
                return user.get();
            } else {
                return null;
            }
    }
    
}
