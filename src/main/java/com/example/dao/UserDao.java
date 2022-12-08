package com.example.dao;

import com.example.pojo.User;
import java.util.List;

//映射器类
public interface UserDao {
    List<User> getUserList();
    Integer getUser_Count();
    List<User> getOneUserList(Integer userId);
    List<User> getOneExitUserList(String userName);
    List<User> getOne_Name_UserList(String userName,String userPwd);
    List<User> addUserList(String user_name,String password,String position,String email);
    List<User> updateUserList(Integer userId,String user_name,String password,String position);
    List<User> deleteUserList(Integer userId);
}
