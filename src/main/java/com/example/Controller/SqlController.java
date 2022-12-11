package com.example.Controller;

import com.example.Utils.MyBatisUtils;
import com.example.dao.UserDao;
import com.example.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SqlController {
    @GetMapping(value = "/sqlList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getSql() throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(userList);
        return s;
    }

    @RequestMapping("/sqlOneList")
    @ResponseBody
    public String getOneSql(@RequestParam("user_id") Integer user_id) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.getOneUserList(user_id);
        for (User user : userList) {
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(userList);
        return s;
    }

    @RequestMapping("/sqlOneNameList")
    @ResponseBody
    public String getOneNameSql(@RequestParam("user_name")String user_name) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.getOneExitUserList(user_name);
        for (User user : userList) {
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(userList);
        return s;
    }

    @RequestMapping("/sqlOneNamePwdList")
    @ResponseBody
    public String getOneNamePwdSql(@RequestParam("user_name") String user_name,@RequestParam("user_pwd") String user_pwd) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.getOne_Name_UserList(user_name,user_pwd);
        for (User user : userList) {
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(userList);
        return s;
    }

    @RequestMapping("/sqlAdd")
    public String addSql(@RequestParam("name") String username, @RequestParam("pwd") String password,@RequestParam("position") String position,@RequestParam("email") String email) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.addUserList(username,password,position,email);
        for (User user : userList) {
            System.out.print(user.getId());
            System.out.print(user.getName());
        }
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

    @RequestMapping("/sqlUpdate")
    public String updateSql(@RequestParam("name") String username, @RequestParam("pwd") String password,@RequestParam("email") String email) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.updateUserList(username,password,email);
        for (User user : userList) {
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

    @RequestMapping("/sqlDelete")
    public String deleteSql(@RequestParam("id")Integer id) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.deleteUserList(id);
        for (User user : userList) {
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

}
