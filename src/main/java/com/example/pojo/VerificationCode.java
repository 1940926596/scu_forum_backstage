package com.example.pojo;

public class VerificationCode {
    private int id;
    private String code;
    private String name;

    public VerificationCode(){}

    public VerificationCode(int id, String name,String code) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public VerificationCode( String name,String code) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
