package com.videosynthesis.tfmBack.repositories;

import com.videosynthesis.tfmBack.models.CaseStudy;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseStudyRepo extends MongoRepository<CaseStudy, String> {
    Optional<CaseStudy> findByTitle(String title);

    void deleteByTitle(String title);

    List<CaseStudy> findByShowCaseTrue();

    Optional<CaseStudy> findBySlug(String slug);
}
