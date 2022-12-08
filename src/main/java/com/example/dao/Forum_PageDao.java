package com.example.dao;

import com.example.pojo.Forum_Page;

import java.util.List;

public interface Forum_PageDao {

    List<Forum_Page> getForum_PageList();

    List<Forum_Page> getOneForum_PageList(Integer page_id);

    List<Forum_Page> getAllForum_PageList(Integer page_sender_id,String page_sender_name);

    Integer getForum_Page_Count();

    List<Forum_Page> addForum_PageList(Integer page_sender_id,String page_sender_name,String page_send_time, String page_send_content);

    List<Forum_Page> updateForum_PageList(Integer page_id,String page_send_content);

    List<Forum_Page> deleteForum_PageList(Integer page_id);
}
