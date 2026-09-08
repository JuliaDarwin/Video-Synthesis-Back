package com.videosynthesis.tfmBack.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.videosynthesis.tfmBack.services.CaseStudyService;
import java.util.List;
import com.videosynthesis.tfmBack.models.CaseStudy;

@RestController
@RequestMapping("/api/case-studies")
@CrossOrigin(origins = "*")
public class CaseStudyController {

    private final CaseStudyService caseStudyService;

    public CaseStudyController(CaseStudyService caseStudyService) {
        this.caseStudyService = caseStudyService;
    }

    @GetMapping
    public List<CaseStudy> getAllCaseStudies() {
        List<CaseStudy> list = caseStudyService.getAllCaseStudies();
        System.out.println("DEBUG >>> getAllCaseStudies count: " + list.size());
        return list;
    }

    @GetMapping("/{title}")
    public ResponseEntity<CaseStudy> getCaseStudyByTitle(@PathVariable String title) {
        return caseStudyService.getCaseStudyByTitle(title)
                .map(ResponseEntity::ok) // IF a CaseStudy was found in MongoDB, wrap it in a 200 OK response box and
                                         // send the data back as JSON to Angular.
                .orElse(ResponseEntity.notFound().build()); // IF nothing was found in MongoDB (e.g. someone searched
                                                            // for a fake title), create a 404 Not Found HTTP response
                                                            // box and send that error code to Angular
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<CaseStudy> getCaseStudyBySlug(@PathVariable String slug) {
        return caseStudyService.getCaseStudyBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/featured") // needs to have its own path otherwise no way to diferenciar amb el normal
    public List<CaseStudy> getFeatured() {
        return caseStudyService.getFeatured();
    }

    @PostMapping
    public CaseStudy createCaseStudy(@RequestBody CaseStudy caseStudy) {
        return caseStudyService.createCaseStudy(caseStudy);
    }

    @DeleteMapping("/{title}")
    public void deleteCaseStudy(@PathVariable String title) {
        this.caseStudyService.deleteCaseStudyByTitle(title);
    }

    @PutMapping("/{title}")
    public CaseStudy updateCaseStudy(@PathVariable String title, @RequestBody CaseStudy caseStudy) {
        return this.caseStudyService.updateCaseStudyByTitle(title, caseStudy);
    }

}
