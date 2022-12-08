package com.example.pojo;

public class Forum_User {
    private Integer forum_id;
    private String forum_name;
    private String forum_pwd;
    private String forum_email;

    public Forum_User(Integer forum_id, String forum_name, String forum_pwd, String forum_email) {
        this.forum_id = forum_id;
        this.forum_name = forum_name;
        this.forum_pwd = forum_pwd;
        this.forum_email = forum_email;
    }

    public Integer getForum_id() {
        return forum_id;
    }

    public void setForum_id(Integer forum_id) {
        this.forum_id = forum_id;
    }

    public String getForum_name() {
        return forum_name;
    }

    public void setForum_name(String forum_name) {
        this.forum_name = forum_name;
    }

    public String getForum_pwd() {
        return forum_pwd;
    }

    public void setForum_pwd(String forum_pwd) {
        this.forum_pwd = forum_pwd;
    }

    public String getForum_email() {
        return forum_email;
    }

    public void setForum_email(String forum_email) {
        this.forum_email = forum_email;
    }
}
