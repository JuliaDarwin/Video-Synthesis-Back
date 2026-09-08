package com.videosynthesis.tfmBack.dto;

public class ContactFormRequest {

    private AboutYou aboutYou;
    private Requirements requirements;
    private TimeBudget timeBudget;
    private AdditionalDetails additionalDetails;

    public AboutYou getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(AboutYou aboutYou) {
        this.aboutYou = aboutYou;
    }

    public Requirements getRequirements() {
        return requirements;
    }

    public void setRequirements(Requirements requirements) {
        this.requirements = requirements;
    }

    public TimeBudget getTimeBudget() {
        return timeBudget;
    }

    public void setTimeBudget(TimeBudget timeBudget) {
        this.timeBudget = timeBudget;
    }

    public AdditionalDetails getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(AdditionalDetails additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public static class AboutYou {
        private String name;
        private String organization;
        private String role;
        private String email;
        private String website;
        private String contactMethod;
        private String projectTitle;
        private String description;
        private String goal;
        private String audience;
        private String message;
        private Platforms platforms;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getOrganization() { return organization; }
        public void setOrganization(String organization) { this.organization = organization; }
        
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public String getWebsite() { return website; }
        public void setWebsite(String website) { this.website = website; }
        
        public String getContactMethod() { return contactMethod; }
        public void setContactMethod(String contactMethod) { this.contactMethod = contactMethod; }
        
        public String getProjectTitle() { return projectTitle; }
        public void setProjectTitle(String projectTitle) { this.projectTitle = projectTitle; }
        
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        
        public String getGoal() { return goal; }
        public void setGoal(String goal) { this.goal = goal; }
        
        public String getAudience() { return audience; }
        public void setAudience(String audience) { this.audience = audience; }
        
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        
        public Platforms getPlatforms() { return platforms; }
        public void setPlatforms(Platforms platforms) { this.platforms = platforms; }
    }

    public static class Platforms {
        private boolean website;
        private boolean instagram;
        private boolean youtube;
        private boolean linkedin;

        public boolean isWebsite() { return website; }
        public void setWebsite(boolean website) { this.website = website; }
        
        public boolean isInstagram() { return instagram; }
        public void setInstagram(boolean instagram) { this.instagram = instagram; }
        
        public boolean isYoutube() { return youtube; }
        public void setYoutube(boolean youtube) { this.youtube = youtube; }
        
        public boolean isLinkedin() { return linkedin; }
        public void setLinkedin(boolean linkedin) { this.linkedin = linkedin; }
    }

    public static class Requirements {
        private Deliverables deliverables;
        private Materials materials;

        public Deliverables getDeliverables() { return deliverables; }
        public void setDeliverables(Deliverables deliverables) { this.deliverables = deliverables; }

        public Materials getMaterials() { return materials; }
        public void setMaterials(Materials materials) { this.materials = materials; }
    }

    public static class Deliverables {
        private boolean mainVideo;
        private boolean socialMediaCutdowns;
        private boolean verticalReels;
        private boolean motionGraphics;
        private boolean infographics;
        private boolean subtitles;
        private boolean translations;
        private boolean campaignVisuals;
        private boolean websiteAssets;
        private boolean notSure;

        public boolean isMainVideo() { return mainVideo; }
        public void setMainVideo(boolean mainVideo) { this.mainVideo = mainVideo; }
        public boolean isSocialMediaCutdowns() { return socialMediaCutdowns; }
        public void setSocialMediaCutdowns(boolean socialMediaCutdowns) { this.socialMediaCutdowns = socialMediaCutdowns; }
        public boolean isVerticalReels() { return verticalReels; }
        public void setVerticalReels(boolean verticalReels) { this.verticalReels = verticalReels; }
        public boolean isMotionGraphics() { return motionGraphics; }
        public void setMotionGraphics(boolean motionGraphics) { this.motionGraphics = motionGraphics; }
        public boolean isInfographics() { return infographics; }
        public void setInfographics(boolean infographics) { this.infographics = infographics; }
        public boolean isSubtitles() { return subtitles; }
        public void setSubtitles(boolean subtitles) { this.subtitles = subtitles; }
        public boolean isTranslations() { return translations; }
        public void setTranslations(boolean translations) { this.translations = translations; }
        public boolean isCampaignVisuals() { return campaignVisuals; }
        public void setCampaignVisuals(boolean campaignVisuals) { this.campaignVisuals = campaignVisuals; }
        public boolean isWebsiteAssets() { return websiteAssets; }
        public void setWebsiteAssets(boolean websiteAssets) { this.websiteAssets = websiteAssets; }
        public boolean isNotSure() { return notSure; }
        public void setNotSure(boolean notSure) { this.notSure = notSure; }
    }

    public static class Materials {
        private boolean rawFootage;
        private boolean interviews;
        private boolean photos;
        private boolean script;
        private boolean brandGuidelines;
        private boolean previousContent;
        private boolean references;
        private boolean dataReports;

        public boolean isRawFootage() { return rawFootage; }
        public void setRawFootage(boolean rawFootage) { this.rawFootage = rawFootage; }
        public boolean isInterviews() { return interviews; }
        public void setInterviews(boolean interviews) { this.interviews = interviews; }
        public boolean isPhotos() { return photos; }
        public void setPhotos(boolean photos) { this.photos = photos; }
        public boolean isScript() { return script; }
        public void setScript(boolean script) { this.script = script; }
        public boolean isBrandGuidelines() { return brandGuidelines; }
        public void setBrandGuidelines(boolean brandGuidelines) { this.brandGuidelines = brandGuidelines; }
        public boolean isPreviousContent() { return previousContent; }
        public void setPreviousContent(boolean previousContent) { this.previousContent = previousContent; }
        public boolean isReferences() { return references; }
        public void setReferences(boolean references) { this.references = references; }
        public boolean isDataReports() { return dataReports; }
        public void setDataReports(boolean dataReports) { this.dataReports = dataReports; }
    }

    public static class TimeBudget {
        private String startDate;
        private String deliverableDate;
        private String deadlineFlexible;
        private String budget;

        public String getStartDate() { return startDate; }
        public void setStartDate(String startDate) { this.startDate = startDate; }
        
        public String getDeliverableDate() { return deliverableDate; }
        public void setDeliverableDate(String deliverableDate) { this.deliverableDate = deliverableDate; }
        
        public String getDeadlineFlexible() { return deadlineFlexible; }
        public void setDeadlineFlexible(String deadlineFlexible) { this.deadlineFlexible = deadlineFlexible; }

        public String getBudget() { return budget; }
        public void setBudget(String budget) { this.budget = budget; }
    }

    public static class AdditionalDetails {
        private String additionalDetails;

        public String getAdditionalDetails() { return additionalDetails; }
        public void setAdditionalDetails(String additionalDetails) { this.additionalDetails = additionalDetails; }
    }
}
