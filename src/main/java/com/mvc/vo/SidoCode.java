package com.mvc.vo;

public class SidoCode {
    private String sidoName;
    private String sidoCode;

    public SidoCode() {
    }

    public SidoCode(String sidoName, String sidoCode) {
        this.sidoName = sidoName;
        this.sidoCode = sidoCode;
    }

    public String getSidoName() {
        return sidoName;
    }

    public String getSidoCode() {
        return sidoCode;
    }

    public void setSidoName(String sidoName) {
        this.sidoName = sidoName;
    }

    public void setSidoCode(String sidoCode) {
        this.sidoCode = sidoCode;
    }
}
