package com.example.pojo;

public class User {
    private int id;
    private String name;
    private String pwd;
    private String position;
    private String email;

    public User(int id, String name, String pwd, String position, String email) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.position = position;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
