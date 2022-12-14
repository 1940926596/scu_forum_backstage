package com.example.dao;

import com.example.pojo.Information;
import com.example.pojo.Information;

import java.util.List;

public interface InformationDao {
    List<Information> getInformationList();
    List<Information> getOneInformationList(Integer transactionId);
    List<Information> getOneUserSellInformationList(Integer sellUserId);
    List<Information> getOneUserBuyInformationList(Integer buyUserId);
    List<Information> addInformationList(Integer bookId, Integer sellUserId, Integer buyUserId,String time);
//    List<Information> updateInformationList(Integer transactionId,String sendUserId, String releaseUserId, Integer bookId);
    List<Information> deleteInformationList(Integer transactionId);
}
