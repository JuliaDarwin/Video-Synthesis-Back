package com.videosynthesis.tfmBack.services;

import com.videosynthesis.tfmBack.models.CaseStudy;
import com.videosynthesis.tfmBack.repositories.CaseStudyRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CaseStudyServiceTest {

    @Mock
    private CaseStudyRepo caseStudyRepo;

    @InjectMocks
    private CaseStudyService caseStudyService;

    @Test // UT-2
    void getAllCaseStudies_returnsAllCaseStudies() {

        // Given
        List<CaseStudy> caseStudies = List.of(
                new CaseStudy(),
                new CaseStudy());

        when(caseStudyRepo.findAll()).thenReturn(caseStudies);

        // When
        List<CaseStudy> result = caseStudyService.getAllCaseStudies();

        // Then
        assertEquals(caseStudies, result);
    }

    @Test // UT3
    void getFeatured_returnsFeaturedCaseStudies() {

        // Given
        List<CaseStudy> featured = List.of(
                new CaseStudy());

        when(caseStudyRepo.findByShowCaseTrue()).thenReturn(featured);

        // When
        List<CaseStudy> result = caseStudyService.getFeatured();

        // Then
        assertEquals(featured, result);
    }

    @Test // UT1
    void createCaseStudy_savesCaseStudy() {

        // Given
        CaseStudy caseStudy = new CaseStudy();

        when(caseStudyRepo.save(caseStudy)).thenReturn(caseStudy);

        // When
        CaseStudy result = caseStudyService.createCaseStudy(caseStudy);

        // Then
        assertEquals(caseStudy, result);
    }

    @Test // UT-4
    void getCaseStudyByTitle_returnsCaseStudy_whenTitleExists() {
        // Given
        String title = "Test Case Study";
        CaseStudy caseStudy = new CaseStudy();

        when(caseStudyRepo.findByTitle(title))
                .thenReturn(Optional.of(caseStudy));

        // When
        Optional<CaseStudy> result = caseStudyService.getCaseStudyByTitle(title);

        // Then
        assertTrue(result.isPresent());
        assertEquals(caseStudy, result.get());
    }

    @Test /// UT-5
    void getCaseStudyByTitle_returnsEmpty_whenTitleDoesNotExist() {

        // Given
        String title = "Nonexistent Case Study";

        when(caseStudyRepo.findByTitle(title))
                .thenReturn(Optional.empty());

        // When
        Optional<CaseStudy> result = caseStudyService.getCaseStudyByTitle(title);

        // Then
        assertTrue(result.isEmpty());
    }

    @Test // UT-6
    void getCaseStudyBySlug_returnsCaseStudy_whenSlugExists() {

        // Given
        String slug = "test-case-study";
        CaseStudy caseStudy = new CaseStudy();

        when(caseStudyRepo.findBySlug(slug))
                .thenReturn(Optional.of(caseStudy));

        // When
        Optional<CaseStudy> result = caseStudyService.getCaseStudyBySlug(slug);

        // Then
        assertTrue(result.isPresent());
        assertEquals(caseStudy, result.get());
    }

    @Test // UT-7
    void getCaseStudyBySlug_returnsEmpty_whenSlugDoesNotExist() {

        // Given
        String slug = "nonexistent-case-study";

        when(caseStudyRepo.findBySlug(slug))
                .thenReturn(Optional.empty());

        // When
        Optional<CaseStudy> result = caseStudyService.getCaseStudyBySlug(slug);

        // Then
        assertTrue(result.isEmpty());
    }

    @Test // UT-8
    void updateCaseStudyById_updatesCaseStudy() {

        // Given
        String id = "123";
        CaseStudy caseStudy = new CaseStudy();

        when(caseStudyRepo.save(caseStudy))
                .thenReturn(caseStudy);

        // When
        CaseStudy result = caseStudyService.updateCaseStudyById(id, caseStudy);

        // Then
        assertEquals(id, caseStudy.getId());
        assertEquals(caseStudy, result);
    }

    @Test // UT-9
    void deleteCaseStudyById_deletesCaseStudy() {

        // Given
        String id = "123";

        // When
        caseStudyService.deleteCaseStudyById(id);

        // Then
        verify(caseStudyRepo).deleteById(id);
    }

    @Test // UT10
    void deleteCaseStudyByTitle_deletesByTitle_whenCaseStudyDoesNotExist() {

        // Given
        String title = "Nonexistent Case Study";

        when(caseStudyRepo.findByTitle(title))
                .thenReturn(Optional.empty());

        when(caseStudyRepo.findBySlug(title))
                .thenReturn(Optional.empty());

        // When
        caseStudyService.deleteCaseStudyByTitle(title);

        // Then
        verify(caseStudyRepo).deleteByTitle(title);
    }

}
