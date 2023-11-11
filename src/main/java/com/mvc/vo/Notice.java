package com.mvc.vo;

public class Notice {

    String num, title, content, wdate, count;


    public Notice() {
    }

    public Notice(String num, String title, String content, String wdate, String count) {
        this.num = num;
        this.title = title;
        this.content = content;
        this.wdate = wdate;
        this.count = count;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
