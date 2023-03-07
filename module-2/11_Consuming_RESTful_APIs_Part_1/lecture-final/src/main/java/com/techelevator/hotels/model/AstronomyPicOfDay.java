package com.techelevator.hotels.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AstronomyPicOfDay {

    @JsonProperty("copyright")
    public String photographer;

    public String date;
    public String explanation;
    public String title;
    public String url;

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
