package com.example.dao;

import com.example.pojo.VerificationCode;

import java.util.List;

public interface VerificationCodeDao {
    List<VerificationCode> getCodeList();
    List<VerificationCode> addCodeList(String name,String code);
}
