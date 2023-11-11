package com.mvc.vo;

public class InterestArea {
    private String userId;
    private String aptCode;
    private String aptName;

    public InterestArea() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAptCode() {
        return aptCode;
    }

    public void setAptCode(String aptCode) {
        this.aptCode = aptCode;
    }

    public String getAptName() {
        return aptName;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    public InterestArea(String userId, String aptCode, String aptName) {
        this.userId = userId;
        this.aptCode = aptCode;
        this.aptName = aptName;
    }
}
