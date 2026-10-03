package com.videosynthesis.tfmBack.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.videosynthesis.tfmBack.models.CaseStudy;
import com.videosynthesis.tfmBack.repositories.CaseStudyRepo;

@Service
public class CaseStudyService {
    private final CaseStudyRepo caseStudyRepo;

    public CaseStudyService(CaseStudyRepo caseStudyRepo) {
        this.caseStudyRepo = caseStudyRepo;
    }

    public List<CaseStudy> getAllCaseStudies() {
        return caseStudyRepo.findAll();
    }

    public Optional<CaseStudy> getCaseStudyByTitle(String title) {
        return caseStudyRepo.findFirstByTitle(title);
    }

    public Optional<CaseStudy> getCaseStudyBySlug(String slug) {
        return caseStudyRepo.findFirstBySlug(slug);
    }

    public List<CaseStudy> getFeatured() {
        return caseStudyRepo.findByShowCaseTrue();
    }

    public CaseStudy createCaseStudy(CaseStudy caseStudy) {
        return caseStudyRepo.save(caseStudy);
    }

    public CaseStudy updateCaseStudyById(String id, CaseStudy caseStudy) {
        caseStudy.setId(id);
        return caseStudyRepo.save(caseStudy);
    }

    public CaseStudy updateCaseStudyByTitle(String identifier, CaseStudy caseStudy) {
        CaseStudy existingCaseStudy = caseStudyRepo.findById(identifier)
                .or(() -> caseStudyRepo.findFirstBySlug(identifier))
                .or(() -> caseStudyRepo.findFirstByTitle(identifier))
                .orElse(null);

        if (existingCaseStudy != null) {
            existingCaseStudy.setSlug(caseStudy.getSlug());
            existingCaseStudy.setTitle(caseStudy.getTitle());
            existingCaseStudy.setDescription(caseStudy.getDescription());
            existingCaseStudy.setPeriod(caseStudy.getPeriod());
            existingCaseStudy.setServices(caseStudy.getServices());
            existingCaseStudy.setTags(caseStudy.getTags());
            existingCaseStudy.setThumbnail(caseStudy.getThumbnail());
            existingCaseStudy.setExternalUrl(caseStudy.getExternalUrl());
            existingCaseStudy.setShowCase(caseStudy.isShowCase());
            existingCaseStudy.setClient(caseStudy.getClient());
            existingCaseStudy.setSubhead(caseStudy.getSubhead());
            existingCaseStudy.setContext(caseStudy.getContext());
            existingCaseStudy.setChallenge(caseStudy.getChallenge());
            existingCaseStudy.setDeliverables(caseStudy.getDeliverables());
            existingCaseStudy.setTasks(caseStudy.getTasks());
            existingCaseStudy.setWork(caseStudy.getWork());
            existingCaseStudy.setMetrics(caseStudy.getMetrics());
            existingCaseStudy.setCampaign(caseStudy.getCampaign());
            existingCaseStudy.setVideos(caseStudy.getVideos());
            existingCaseStudy.setMainVideo(caseStudy.getMainVideo());
            return caseStudyRepo.save(existingCaseStudy);
        }
        return caseStudyRepo.save(caseStudy);
    }

    public void deleteCaseStudyById(String id) {
        caseStudyRepo.deleteById(id);
    }

    public void deleteCaseStudyByTitle(String identifier) {
        List<CaseStudy> bySlug = caseStudyRepo.findAllBySlug(identifier);
        if (!bySlug.isEmpty()) {
            caseStudyRepo.deleteAll(bySlug);
            return;
        }
        List<CaseStudy> byTitle = caseStudyRepo.findAllByTitle(identifier);
        if (!byTitle.isEmpty()) {
            caseStudyRepo.deleteAll(byTitle);
            return;
        }
        if (caseStudyRepo.existsById(identifier)) {
            caseStudyRepo.deleteById(identifier);
        }
    }
}
