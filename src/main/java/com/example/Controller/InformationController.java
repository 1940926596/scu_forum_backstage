package com.example.Controller;

import com.example.Utils.MyBatisUtils;
import com.example.dao.InformationDao;
import com.example.pojo.Information;
import com.example.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InformationController {
    @GetMapping(value = "/InformationList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getSql() throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
        //可以调用mapper的方法
        List<Information> informationList = mapper.getInformationList();
        for (Information information : informationList) {
            System.out.print(information.getTransactionId());
            System.out.print(information.getReleaseUserId());
            System.out.println(information.getSendUserId());
            System.out.println(information.getBookId());
        }
        //关闭SqlSession
        sqlSession.close();

        ObjectMapper mapper1 = new ObjectMapper();

        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(informationList);

        return s;
    }

    @RequestMapping("/InformationOneList")
    public String getOneSql() {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
        //可以调用mapper的方法
        List<Information> informationList = mapper.getOneInformationList(1);
        for (Information information : informationList) {
            System.out.print(information.getTransactionId());
            System.out.print(information.getReleaseUserId());
            System.out.println(information.getSendUserId());
            System.out.println(information.getBookId());
        }
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

//    @RequestMapping("/InformationAdd")
//    public String addSql(@RequestParam("name") String username, @RequestParam("pwd") String password) {
//        //获取sqlSession（mybatis-config读取成功）
//        SqlSession sqlSession = MyBatisUtils.getSqlSession();
//
//        //方式一
//        //先连接mapper里面的userDao
//        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
//        //可以调用mapper的方法
//        List<User> userList = mapper.addUserList(username,password);
//        for (User user : userList) {
//            System.out.print(user.getId());
//            System.out.print(user.getName());
//            System.out.println(user.getPwd());
//        }
//        //关闭SqlSession
//        sqlSession.close();
//        return "index";
//    }
//
//    @RequestMapping("/InformationUpdate")
//    public String updateSql() {
//        //获取sqlSession（mybatis-config读取成功）
//        SqlSession sqlSession = MyBatisUtils.getSqlSession();
//
//        //方式一
//        //先连接mapper里面的userDao
//        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
//        //可以调用mapper的方法
//        List<User> userList = mapper.updateUserList(2,"2","2");
//        for (User user : userList) {
//            System.out.print(user.getId());
//            System.out.print(user.getName());
//            System.out.println(user.getPwd());
//        }
//        //关闭SqlSession
//        sqlSession.close();
//        return "index";
//    }
//
//    @RequestMapping("/InformationDelete")
//    public String deleteSql() {
//        //获取sqlSession（mybatis-config读取成功）
//        SqlSession sqlSession = MyBatisUtils.getSqlSession();
//
//        //方式一
//        //先连接mapper里面的userDao
//        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
//        //可以调用mapper的方法
//        List<User> userList = mapper.deleteUserList(1);
//        for (User user : userList) {
//            System.out.print(user.getId());
//            System.out.print(user.getName());
//            System.out.println(user.getPwd());
//        }
//        //关闭SqlSession
//        sqlSession.close();
//        return "index";
//    }

}
