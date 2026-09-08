package com.videosynthesis.tfmBack.repositories;

import com.videosynthesis.tfmBack.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    
    // Very useful if you need to fetch a specific role from the DB before assigning it to a user
    Optional<Role> findByName(String name);
    
}
