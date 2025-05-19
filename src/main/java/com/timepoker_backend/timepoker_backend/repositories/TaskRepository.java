package com.timepoker_backend.timepoker_backend.repositories;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.timepoker_backend.timepoker_backend.models.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
    
    Optional<Task> findById(String id);
}
