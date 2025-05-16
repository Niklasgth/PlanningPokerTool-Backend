package com.timepoker_backend.timepoker_backend.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.timepoker_backend.timepoker_backend.models.User;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findById(String id);

    Optional<User> findByUserName(String userName);
}
