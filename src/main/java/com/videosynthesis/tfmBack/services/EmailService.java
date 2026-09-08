package com.videosynthesis.tfmBack.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import com.videosynthesis.tfmBack.dto.ContactFormRequest;

@Service
public class EmailService {
    @Value("${resend.api-key}")
    private String apiKey;

    @Value("${resend.send-to}")
    private String sendTo;

    @Value("${resend.send-from}")
    private String sendFrom;

    public void sendContactEmail(ContactFormRequest request) {
        Resend resend = new Resend(apiKey);

        StringBuilder html = new StringBuilder();
        html.append("<h3>New Contact Form Submission</h3>");
        
        String contactName = "Unknown";
        String contactEmail = "no-reply@example.com";

        ContactFormRequest.AboutYou about = request.getAboutYou();
        if (about != null) {
            contactName = about.getName() != null ? about.getName() : contactName;
            contactEmail = about.getEmail() != null ? about.getEmail() : contactEmail;

            html.append("<h4>About You</h4>");
            html.append("<p><strong>Name:</strong> ").append(about.getName()).append("</p>");
            html.append("<p><strong>Email:</strong> ").append(about.getEmail()).append("</p>");
            html.append("<p><strong>Organization:</strong> ").append(about.getOrganization()).append("</p>");
            html.append("<p><strong>Role:</strong> ").append(about.getRole()).append("</p>");
            html.append("<p><strong>Website:</strong> ").append(about.getWebsite()).append("</p>");
            html.append("<p><strong>Preferred Contact Method:</strong> ").append(about.getContactMethod()).append("</p>");
            html.append("<p><strong>Project Title:</strong> ").append(about.getProjectTitle()).append("</p>");
            html.append("<p><strong>Description:</strong> ").append(about.getDescription()).append("</p>");
            html.append("<p><strong>Goal:</strong> ").append(about.getGoal()).append("</p>");
            html.append("<p><strong>Target Audience:</strong> ").append(about.getAudience()).append("</p>");
            html.append("<p><strong>Key Message:</strong> ").append(about.getMessage()).append("</p>");
            
            if (about.getPlatforms() != null) {
                html.append("<p><strong>Platforms:</strong> ");
                if (about.getPlatforms().isWebsite()) html.append("Website, ");
                if (about.getPlatforms().isInstagram()) html.append("Instagram, ");
                if (about.getPlatforms().isYoutube()) html.append("YouTube, ");
                if (about.getPlatforms().isLinkedin()) html.append("LinkedIn, ");
                html.append("</p>");
            }
        }

        ContactFormRequest.Requirements req = request.getRequirements();
        if (req != null) {
            html.append("<h4>Requirements</h4>");
            if (req.getDeliverables() != null) {
                html.append("<p><strong>Deliverables:</strong> ");
                if (req.getDeliverables().isMainVideo()) html.append("Main Video, ");
                if (req.getDeliverables().isSocialMediaCutdowns()) html.append("Social Media Cutdowns, ");
                if (req.getDeliverables().isVerticalReels()) html.append("Vertical Reels, ");
                if (req.getDeliverables().isMotionGraphics()) html.append("Motion Graphics, ");
                if (req.getDeliverables().isInfographics()) html.append("Infographics, ");
                if (req.getDeliverables().isSubtitles()) html.append("Subtitles, ");
                if (req.getDeliverables().isTranslations()) html.append("Translations, ");
                if (req.getDeliverables().isCampaignVisuals()) html.append("Campaign Visuals, ");
                if (req.getDeliverables().isWebsiteAssets()) html.append("Website Assets, ");
                if (req.getDeliverables().isNotSure()) html.append("Not sure yet, ");
                html.append("</p>");
            }
            if (req.getMaterials() != null) {
                html.append("<p><strong>Materials Available:</strong> ");
                if (req.getMaterials().isRawFootage()) html.append("Raw Footage, ");
                if (req.getMaterials().isInterviews()) html.append("Interviews, ");
                if (req.getMaterials().isPhotos()) html.append("Photos, ");
                if (req.getMaterials().isScript()) html.append("Script, ");
                if (req.getMaterials().isBrandGuidelines()) html.append("Brand Guidelines, ");
                if (req.getMaterials().isPreviousContent()) html.append("Previous Content, ");
                if (req.getMaterials().isReferences()) html.append("References, ");
                if (req.getMaterials().isDataReports()) html.append("Data/Reports, ");
                html.append("</p>");
            }
        }

        ContactFormRequest.TimeBudget tb = request.getTimeBudget();
        if (tb != null) {
            html.append("<h4>Time & Budget</h4>");
            html.append("<p><strong>Start Date:</strong> ").append(tb.getStartDate()).append("</p>");
            html.append("<p><strong>Desired Deliverable Date:</strong> ").append(tb.getDeliverableDate()).append("</p>");
            html.append("<p><strong>Flexible Deadline:</strong> ").append(tb.getDeadlineFlexible()).append("</p>");
            html.append("<p><strong>Budget:</strong> ").append(tb.getBudget()).append("</p>");
        }

        ContactFormRequest.AdditionalDetails ad = request.getAdditionalDetails();
        if (ad != null && ad.getAdditionalDetails() != null) {
            html.append("<h4>Additional Details</h4>");
            html.append("<p>").append(ad.getAdditionalDetails()).append("</p>");
        }

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from(sendFrom)
                .to(sendTo)
                .subject("New Contact Request from " + contactName)
                .html(html.toString())
                .replyTo(contactEmail) 
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println("Email sent successfully! ID: " + data.getId());
        } catch (ResendException e) {
            throw new RuntimeException("Failed to send email via Resend", e);
        }
    }
}