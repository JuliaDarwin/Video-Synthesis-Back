package com.videosynthesis.tfmBack.repositories;

import com.videosynthesis.tfmBack.models.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    // This method will be needed by Spring Security to find users when they log in!
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

}
