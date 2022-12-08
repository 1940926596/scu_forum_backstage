package com.example.dao;

import com.example.pojo.Information;
import com.example.pojo.Information;

import java.util.List;

public interface InformationDao {
    List<Information> getInformationList();
    List<Information> getOneInformationList(Integer transactionId);
    List<Information> addInformationList(Integer transactionId, String sendUserId, String releaseUserId, Integer bookId);
    List<Information> updateInformationList(String sendUserId, String releaseUserId, Integer bookId);
    List<Information> deleteInformationList(Integer transactionId);
}
