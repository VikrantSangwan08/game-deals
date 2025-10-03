package com.vikrant.gamedeals.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prefrence {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String prefenceId;
    private String region;
    private String genre;
    private String maxamount;
    private List<String> storePreferred;
    private Integer alertFrequency;

    public Prefrence(){

    }

    public String getRegion() {
        return region;
    }
    public Prefrence(String region, String genre, String maxamount, List<String> storePreferred,
    Integer alertFrequency) {
        this.region = region;
        this.genre = genre;
        this.maxamount = maxamount;
        this.storePreferred = storePreferred;
        this.alertFrequency = alertFrequency;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getMaxamount() {
        return maxamount;
    }
    public void setMaxamount(String maxamount) {
        this.maxamount = maxamount;
    }
    public List<String> getStorePreferred() {
        return storePreferred;
    }
    public void setStorePreferred(List<String> storePreferred) {
        this.storePreferred = storePreferred;
    }
    public Integer getAlertFrequency() {
        return alertFrequency;
    }
    public void setAlertFrequency(Integer alertFrequency) {
        this.alertFrequency = alertFrequency;
    }

    public String getPrefenceId() {
        return prefenceId;
    }

    public void setPrefenceId(String prefenceId) {
        this.prefenceId = prefenceId;
    }
    
}
