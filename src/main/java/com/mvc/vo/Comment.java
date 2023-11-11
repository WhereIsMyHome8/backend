package com.mvc.vo;

public class Comment {
    private int no;
    private int qna_num;
    private String user_id;
    private String wdate;
    private String content;

    public Comment() {
    }

    public Comment(int no, int qna_num, String user_id, String wdate, String content) {
        this.no = no;
        this.qna_num = qna_num;
        this.user_id = user_id;
        this.wdate = wdate;
        this.content = content;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getQna_num() {
        return qna_num;
    }

    public void setQna_num(int qna_num) {
        this.qna_num = qna_num;
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
