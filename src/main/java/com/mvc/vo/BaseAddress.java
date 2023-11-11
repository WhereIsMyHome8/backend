package com.mvc.vo;

public class BaseAddress {
    private String no;
    private String sidoName;
    private String gugunName;
    private String dongName;
    private String dongCode;

    private String lat;

    private String lng;

    private String jibun;

    public BaseAddress() {
    }

    public BaseAddress(String no, String sidoName, String gugunName, String dongName, String dongCode, String lat, String lng, String jibun) {
        this.no = no;
        this.sidoName = sidoName;
        this.gugunName = gugunName;
        this.dongName = dongName;
        this.dongCode = dongCode;
        this.lat = lat;
        this.lng = lng;
        this.jibun = jibun;
    }

    public String getJibun() {
        return jibun;
    }

    public void setJibun(String jibun) {
        this.jibun = jibun;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setSidoName(String sidoName) {
        this.sidoName = sidoName;
    }

    public void setGugunName(String gugunName) {
        this.gugunName = gugunName;
    }

    public void setDongName(String dongName) {
        this.dongName = dongName;
    }

    public void setDongCode(String dongCode) {
        this.dongCode = dongCode;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getNo() {
        return no;
    }

    public String getSidoName() {
        return sidoName;
    }

    public String getGugunName() {
        return gugunName;
    }

    public String getDongName() {
        return dongName;
    }

    public String getDongCode() {
        return dongCode;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
