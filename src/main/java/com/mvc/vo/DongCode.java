package com.mvc.vo;

public class DongCode {
    private String DongName;
    private String DongCode;

    public DongCode() {
    }

    public DongCode(String dongName, String dongCode) {
        DongName = dongName;
        DongCode = dongCode;
    }

    public String getDongName() {
        return DongName;
    }

    public void setDongName(String dongName) {
        DongName = dongName;
    }

    public String getDongCode() {
        return DongCode;
    }

    public void setDongCode(String dongCode) {
        DongCode = dongCode;
    }
}
