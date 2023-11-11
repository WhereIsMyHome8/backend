package com.mvc.vo;

public class GugunCode {
    private String gugunName;
    private String gugunCode;

    public String getGugunName() {
        return gugunName;
    }

    public void setGugunName(String gugunName) {
        this.gugunName = gugunName;
    }

    public String getGugunCode() {
        return gugunCode;
    }

    public void setGugunCode(String gugunCode) {
        this.gugunCode = gugunCode;
    }

    public GugunCode() {
    }

    public GugunCode(String gugunName, String gugunCode) {
        this.gugunName = gugunName;
        this.gugunCode = gugunCode;
    }
}
