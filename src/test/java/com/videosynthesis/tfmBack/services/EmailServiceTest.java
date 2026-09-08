package com.videosynthesis.tfmBack.services;

import com.videosynthesis.tfmBack.dto.ContactFormRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    @Test // UT-11
    void sendContactEmail_attemptsToSendAndFailsWithFakeKey() {
        // Given
        // 1. Manually inject fake properties into the @Value fields
        ReflectionTestUtils.setField(emailService, "apiKey", "re_fake_key_123");
        ReflectionTestUtils.setField(emailService, "sendTo", "test-to@example.com");
        ReflectionTestUtils.setField(emailService, "sendFrom", "test-from@example.com");

        // 2. Create a dummy contact request
        ContactFormRequest request = new ContactFormRequest();
        ContactFormRequest.AboutYou aboutYou = new ContactFormRequest.AboutYou();
        aboutYou.setName("Test User");
        aboutYou.setEmail("test@user.com");
        request.setAboutYou(aboutYou);

        // When & Then
        // Because we used a fake API key, the Resend client will throw an exception when it tries to connect.
        // We verify that our service correctly catches it and throws our custom RuntimeException.
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            emailService.sendContactEmail(request);
        });

        // Verify the exception message matches what we wrote in EmailService.java
        assertTrue(exception.getMessage().contains("Failed to send email via Resend"));
    }
}
