package com.example.pojo;

public class Forum_Page {
    private Integer page_id;
    private Integer page_sender_id;
    private String page_sender_name;
    private String page_send_time;
    private String page_send_content;

    public Forum_Page(Integer page_id, Integer page_sender_id, String page_sender_name, String page_sender_time, String page_sender_content) {
        this.page_id = page_id;
        this.page_sender_id = page_sender_id;
        this.page_sender_name = page_sender_name;
        this.page_send_time = page_sender_time;
        this.page_send_content = page_sender_content;
    }

    public Integer getPage_id() {
        return page_id;
    }

    public void setPage_id(Integer page_id) {
        this.page_id = page_id;
    }

    public Integer getPage_sender_id() {
        return page_sender_id;
    }

    public void setPage_sender_id(Integer page_sender_id) {
        this.page_sender_id = page_sender_id;
    }

    public String getPage_sender_name() {
        return page_sender_name;
    }

    public void setPage_sender_name(String page_sender_name) {
        this.page_sender_name = page_sender_name;
    }

    public String getPage_send_time() {
        return page_send_time;
    }

    public void setPage_send_time(String page_sender_time) {
        this.page_send_time = page_sender_time;
    }

    public String getPage_send_content() {
        return page_send_content;
    }

    public void setPage_send_content(String page_sender_content) {
        this.page_send_content = page_sender_content;
    }
}
