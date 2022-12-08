package com.example.pojo;

public class Forum_Message {
    private Integer message_id;
    private Integer message_content_id;
    private String message_sender_name;
    private String message_content;
    private String message_send_time;

    public Forum_Message(Integer message_id, Integer message_content_id, String message_sender_name, String message_content, String message_send_time) {
        this.message_id = message_id;
        this.message_content_id = message_content_id;
        this.message_sender_name = message_sender_name;
        this.message_content = message_content;
        this.message_send_time = message_send_time;
    }

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getMessage_content_id() {
        return message_content_id;
    }

    public void setMessage_content_id(Integer message_content_id) {
        this.message_content_id = message_content_id;
    }

    public String getMessage_sender_name() {
        return message_sender_name;
    }

    public void setMessage_sender_name(String message_sender_name) {
        this.message_sender_name = message_sender_name;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public String getMessage_send_time() {
        return message_send_time;
    }

    public void setMessage_send_time(String message_send_time) {
        this.message_send_time = message_send_time;
    }
}
