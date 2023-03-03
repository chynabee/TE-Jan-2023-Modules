package com.techelevator.model;

import java.time.LocalDateTime;

public class Sighting {

    private int sightingId;
    private String identificationExplaination;
    private LocalDateTime sightingDateTime;
    private String city;
    private String stateAbbreviation;
    private String description;
    private boolean debunked;
    private boolean policeReport;

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public String getIdentificationExplaination() {
        return identificationExplaination;
    }

    public void setIdentificationExplaination(String identificationExplaination) {
        this.identificationExplaination = identificationExplaination;
    }

    public LocalDateTime getSightingDateTime() {
        return sightingDateTime;
    }

    public void setSightingDateTime(LocalDateTime sightingDateTime) {
        this.sightingDateTime = sightingDateTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDebunked() {
        return debunked;
    }

    public void setDebunked(boolean debunked) {
        this.debunked = debunked;
    }

    public boolean isPoliceReport() {
        return policeReport;
    }

    public void setPoliceReport(boolean policeReport) {
        this.policeReport = policeReport;
    }
}
