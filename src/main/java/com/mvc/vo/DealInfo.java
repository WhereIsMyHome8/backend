package com.mvc.vo;

public class DealInfo {
    private String aptName;
    private String minDeal;
    private String maxDeal;
    private String lng;
    private String lat;
    private String buildYear;
    private String area;
    private String aptCode;
    public DealInfo() {
    }

    public DealInfo(String aptName, String minDeal, String maxDeal, String lng, String lat, String buildYear, String area, String aptCode) {
        this.aptName = aptName;
        this.minDeal = minDeal;
        this.maxDeal = maxDeal;
        this.lng = lng;
        this.lat = lat;
        this.buildYear = buildYear;
        this.area = area;
        this.aptCode = aptCode;
    }

    public String getAptName() {
        return aptName;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    public String getMinDeal() {
        return minDeal;
    }

    public void setMinDeal(String minDeal) {
        this.minDeal = minDeal;
    }

    public String getMaxDeal() {
        return maxDeal;
    }

    public void setMaxDeal(String maxDeal) {
        this.maxDeal = maxDeal;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAptCode() {
        return aptCode;
    }

    public void setAptCode(String aptCode) {
        this.aptCode = aptCode;
    }
}
