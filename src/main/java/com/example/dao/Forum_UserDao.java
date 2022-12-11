package com.example.dao;

import com.example.pojo.Forum_User;

import java.util.List;

public interface Forum_UserDao {
    List<Forum_User> getForum_UserList();
    List<Forum_User> getOneForum_UserList(String forum_user_name);
    List<Forum_User> getOneForum_Email_UserList(String forum_user_email);
    List<Forum_User> getOneForum_UserList_Email(String forum_user_email,String forum_user_pwd);
    Integer getForum_User_Count();
    List<Forum_User> addForum_UserList(String forum_name,String forum_pwd,String forum_email);
    List<Forum_User> updateForum_UserList(Integer forum_id,String forum_name);
    List<Forum_User> updateForum_UserEmailList(Integer forum_id,String forum_name,String forum_email);
    List<Forum_User> updateForum_UserEmailPwdList(Integer forum_id,String forum_name,String forum_email,String forum_pwd);
    List<Forum_User> deleteForum_UserList(String forum_name);
}
