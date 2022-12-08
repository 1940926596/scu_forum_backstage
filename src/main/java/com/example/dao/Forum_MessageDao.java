package com.example.dao;

import com.example.pojo.Forum_Message;

import java.util.List;

public interface Forum_MessageDao {

    List<Forum_Message> getForum_MessageList();

    List<Forum_Message> getOneForum_MessageList(Integer message_id);

    List<Forum_Message> getAllForum_MessageList(Integer message_content_id);


    Integer getForum_Message_Count();

    List<Forum_Message> addForum_MessageList(Integer message_content_id, String message_sender_name, String message_content,String message_send_time);

    List<Forum_Message> updateForum_MessageList(Integer message_id,String message_content);

    List<Forum_Message> deleteForum_MessageList(Integer message_id);
}
