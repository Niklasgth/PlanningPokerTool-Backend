package com.timepoker_backend.timepoker_backend.repositories;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.timepoker_backend.timepoker_backend.models.TaskEstimate;

public interface TaskEstimateRepository extends MongoRepository<TaskEstimate, String> {
    
    Optional<TaskEstimate> findById(String id);
}
