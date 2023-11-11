package com.mvc.vo;

public class Notice_Comment {

    private int no;
    private int notice_num;
    private String user_id;
    private String wdate;
    private String content;

    public Notice_Comment(int no, int notice_num, String user_id, String wdate, String content) {
        this.no = no;
        this.notice_num = notice_num;
        this.user_id = user_id;
        this.wdate = wdate;
        this.content = content;
    }

    public Notice_Comment() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNotice_num() {
        return notice_num;
    }

    public void setNotice_num(int notice_num) {
        this.notice_num = notice_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
