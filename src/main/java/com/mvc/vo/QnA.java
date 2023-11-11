package com.mvc.vo;

public class QnA {
    private int num;
    private String user_id;
    private String title;
    private String content;
    private String wdate;
    private String count;
    private Boolean done;

    public QnA() {
    }

    public QnA(int num, String user_id, String title, String content, String wdate, String count, Boolean done) {
        this.num = num;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.wdate = wdate;
        this.count = count;
        this.done = done;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
