package com.example.Controller;

import com.example.Utils.MyBatisUtils;
import com.example.dao.Forum_UserDao;
import com.example.dao.UserDao;
import com.example.pojo.Forum_User;
import com.example.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Forum_UserController {
    @GetMapping(value = "/forum_user_list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getForum_User() throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。
        Forum_UserDao mapper = sqlSession.getMapper(Forum_UserDao.class);
        //可以调用mapper的方法

        List<Forum_User> userList = mapper.getForum_UserList();
        for (Forum_User user : userList) {
            System.out.print(user.getForum_id());
            System.out.print(user.getForum_name());
            System.out.println(user.getForum_pwd());
            System.out.println(user.getForum_email());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String userLists = mapper1.writeValueAsString(userList);
        return userLists;
    }

    @GetMapping(value = "/forum_oneUser_list")
    @ResponseBody
    public String getForum_One_User(@RequestParam("forum_user_name") String forum_user_name) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        Forum_UserDao mapper = sqlSession.getMapper(Forum_UserDao.class);
        //可以调用mapper的方法
        List<Forum_User> userList = mapper.getOneForum_UserList(forum_user_name);
        for (Forum_User user : userList) {
            System.out.print(user.getForum_id());
            System.out.print(user.getForum_name());
            System.out.println(user.getForum_pwd());
            System.out.println(user.getForum_email());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String userLists = mapper1.writeValueAsString(userList);
        return userLists;
    }

    @GetMapping(value = "/forum_oneUser_email_list")
    @ResponseBody
    public String getForum_One_Email_User(@RequestParam("forum_user_email") String forum_user_email) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        Forum_UserDao mapper = sqlSession.getMapper(Forum_UserDao.class);
        //可以调用mapper的方法
        List<Forum_User> userList = mapper.getOneForum_Email_UserList(forum_user_email);
        for (Forum_User user : userList) {
            System.out.print(user.getForum_id());
            System.out.print(user.getForum_name());
            System.out.println(user.getForum_pwd());
            System.out.println(user.getForum_email());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String userLists = mapper1.writeValueAsString(userList);
        return userLists;
    }


    @GetMapping(value = "/forum_oneUser_list_email")
    @ResponseBody
    public String getForum_One_User_Email(@RequestParam("forum_user_email") String forum_user_email,@RequestParam("forum_user_pwd") String forum_user_pwd) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        Forum_UserDao mapper = sqlSession.getMapper(Forum_UserDao.class);
        //可以调用mapper的方法
        List<Forum_User> userList = mapper.getOneForum_UserList_Email(forum_user_email,forum_user_pwd);
        for (Forum_User user : userList) {
            System.out.print(user.getForum_id());
            System.out.print(user.getForum_name());
            System.out.println(user.getForum_pwd());
            System.out.println(user.getForum_email());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String userLists = mapper1.writeValueAsString(userList);
        return userLists;
    }

    @PostMapping("/forum_user_add")
    @ResponseBody
    public String addForum_One_User(@RequestBody Forum_User forum_user) throws JsonProcessingException {
//    public String addForum_One_User(@RequestParam("forum_user_name") String forum_name,@RequestParam("forum_pwd") String forum_pwd,@RequestParam("forum_email") String forum_email) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的userDao
        Forum_UserDao mapper = sqlSession.getMapper(Forum_UserDao.class);
        //可以调用mapper的方法
//        List<Forum_User> userList = mapper.addForum_UserList(forum_name,forum_pwd,forum_email);
        List<Forum_User> userList = mapper.addForum_UserList(forum_user.getForum_name(),forum_user.getForum_pwd(),forum_user.getForum_email());
        for (Forum_User user : userList) {
            System.out.print(user.getForum_id());
            System.out.print(user.getForum_name());
            System.out.println(user.getForum_pwd());
            System.out.println(user.getForum_email());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String userLists = mapper1.writeValueAsString(userList);
        return userLists;
    }

    @RequestMapping("/forum_user_update")
    @ResponseBody
    public String updateForum_User(@RequestParam("forum_id") Integer forum_id,@RequestParam("forum_name") String forum_name) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        Forum_UserDao mapper = sqlSession.getMapper(Forum_UserDao.class);
        //可以调用mapper的方法
        List<Forum_User> userList = mapper.updateForum_UserList(forum_id,forum_name);
        for (Forum_User user : userList) {
            System.out.print(user.getForum_id());
            System.out.print(user.getForum_name());
            System.out.println(user.getForum_pwd());
            System.out.println(user.getForum_email());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String userLists = mapper1.writeValueAsString(userList);
        return userLists;
    }

    @RequestMapping("/forum_user_email_update")
    @ResponseBody
    public String updateForum_EmailUser(@RequestParam("forum_id") Integer forum_id,@RequestParam("forum_name") String forum_name,@RequestParam("forum_email") String forum_email) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        Forum_UserDao mapper = sqlSession.getMapper(Forum_UserDao.class);
        //可以调用mapper的方法
        List<Forum_User> userList = mapper.updateForum_UserEmailList(forum_id,forum_name,forum_email);
        for (Forum_User user : userList) {
            System.out.print(user.getForum_id());
            System.out.print(user.getForum_name());
            System.out.println(user.getForum_pwd());
            System.out.println(user.getForum_email());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String userLists = mapper1.writeValueAsString(userList);
        return userLists;
    }

    @RequestMapping("/forum_user_delete")
    public String deleteForum_User(@RequestParam("forum_user_name") String forum_user_name) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        Forum_UserDao mapper = sqlSession.getMapper(Forum_UserDao.class);
        //可以调用mapper的方法
        List<Forum_User> userList = mapper.deleteForum_UserList(forum_user_name);
        for (Forum_User user : userList) {
            System.out.print(user.getForum_id());
            System.out.print(user.getForum_name());
            System.out.println(user.getForum_pwd());
            System.out.println(user.getForum_email());
        }
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

}
