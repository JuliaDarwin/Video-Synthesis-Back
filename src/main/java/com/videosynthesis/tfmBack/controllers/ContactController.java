package com.videosynthesis.tfmBack.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.videosynthesis.tfmBack.services.EmailService;
import com.videosynthesis.tfmBack.dto.ContactFormRequest;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:4200") // Allows Angular to call this API during local dev
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody ContactFormRequest request) {
        try {
            emailService.sendContactEmail(request);
            return ResponseEntity.ok("Message sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage() + (e.getCause() != null ? " - " + e.getCause().getMessage() : ""));
        }
    }
}