package com.videosynthesis.tfmBack.models;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "case_studies")
public class CaseStudy {

    @Id
    private String id;
    private String slug;
    private String title;
    private String description;
    private String period;
    private String services;
    private List<String> tags;
    private String thumbnail;
    private String externalUrl;
    private boolean showCase;
    private String client;
    private String subhead;
    private String context;
    private String challenge;
    private List<String> deliverables;
    private List<String> tasks;
    private List<Work> work;
    private List<MetricItem> metrics;
    private List<CampaignItem> campaign;
    private List<Video> videos;
    private Video mainVideo;

    public CaseStudy() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public boolean isShowCase() {
        return showCase;
    }

    public void setShowCase(boolean showCase) {
        this.showCase = showCase;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public List<String> getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(List<String> deliverables) {
        this.deliverables = deliverables;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<Work> getWork() {
        return work;
    }

    public void setWork(List<Work> work) {
        this.work = work;
    }

    public List<MetricItem> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<MetricItem> metrics) {
        this.metrics = metrics;
    }

    public List<CampaignItem> getCampaign() {
        return campaign;
    }

    public void setCampaign(List<CampaignItem> campaign) {
        this.campaign = campaign;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Video getMainVideo() {
        return mainVideo;
    }

    public void setMainVideo(Video mainVideo) {
        this.mainVideo = mainVideo;
    }

    // Nested Classes for Object & Array properties
    public static class Work {
        private String image;
        private String description;

        public Work() {
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class MetricItem {
        private String number;
        private String text;

        public MetricItem() {
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class CampaignItem {
        private String title;
        private String image;

        public CampaignItem() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class Video {
        private String url;
        private String description;

        public Video() {
        }

        public Video(String url, String description) {
            this.url = url;
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
