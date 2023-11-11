package com.mvc.vo;

public class DealInfos {
    private String no;
    private String aptCode;
    private String dealAmount;
    private String dealYear;
    private String dealMonth;
    private String dealDay;
    private String area;
    private String floor;
    private String cancelDealType;

    public DealInfos(String no, String aptCode, String dealAmount, String dealYear, String dealMonth, String dealDay, String area, String floor, String cancelDealType, String rentMoney) {
        this.no = no;
        this.aptCode = aptCode;
        this.dealAmount = dealAmount;
        this.dealYear = dealYear;
        this.dealMonth = dealMonth;
        this.dealDay = dealDay;
        this.area = area;
        this.floor = floor;
        this.cancelDealType = cancelDealType;
    }

    public DealInfos() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAptCode() {
        return aptCode;
    }

    public void setAptCode(String aptCode) {
        this.aptCode = aptCode;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getDealYear() {
        return dealYear;
    }

    public void setDealYear(String dealYear) {
        this.dealYear = dealYear;
    }

    public String getDealMonth() {
        return dealMonth;
    }

    public void setDealMonth(String dealMonth) {
        this.dealMonth = dealMonth;
    }

    public String getDealDay() {
        return dealDay;
    }

    public void setDealDay(String dealDay) {
        this.dealDay = dealDay;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCancelDealType() {
        return cancelDealType;
    }

    public void setCancelDealType(String cancelDealType) {
        this.cancelDealType = cancelDealType;
    }


    @Override
    public String toString() {
        return "DealInfos{" +
                "no='" + no + '\'' +
                ", aptCode='" + aptCode + '\'' +
                ", dealAmount='" + dealAmount + '\'' +
                ", dealYear='" + dealYear + '\'' +
                ", dealMonth='" + dealMonth + '\'' +
                ", dealDay='" + dealDay + '\'' +
                ", area='" + area + '\'' +
                ", floor='" + floor + '\'' +
                ", type='" + cancelDealType + '\'' +
                '}';
    }
}
