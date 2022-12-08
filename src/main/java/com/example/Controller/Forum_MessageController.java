package com.example.Controller;

import com.example.Utils.MyBatisUtils;
import com.example.dao.Forum_MessageDao;
import com.example.dao.Forum_MessageDao;
import com.example.pojo.Forum_Message;
import com.example.pojo.Forum_Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Forum_MessageController {
    @GetMapping(value = "/forum_message_list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getForum_Message() throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的messageDao
        //映射器是一些绑定映射语句的接口。
        Forum_MessageDao mapper = sqlSession.getMapper(Forum_MessageDao.class);
        //可以调用mapper的方法

        List<Forum_Message> messageList = mapper.getForum_MessageList();
        for (Forum_Message message : messageList) {
            System.out.print(message.getMessage_id());
            System.out.print(message.getMessage_content_id());
            System.out.println(message.getMessage_sender_name());
            System.out.println(message.getMessage_content());
            System.out.println(message.getMessage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String messageLists = mapper1.writeValueAsString(messageList);
        return messageLists;
    }

    @GetMapping(value = "/forum_oneMessage_list")
    @ResponseBody
    public String getForum_One_Message(@RequestParam("forum_message_id") Integer forum_message_id) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的messageDao
        //映射器是一些绑定映射语句的接口。映射器实例
        Forum_MessageDao mapper = sqlSession.getMapper(Forum_MessageDao.class);
        //可以调用mapper的方法
        List<Forum_Message> messageList = mapper.getOneForum_MessageList(forum_message_id);
        for (Forum_Message message : messageList) {
            System.out.print(message.getMessage_id());
            System.out.print(message.getMessage_content_id());
            System.out.println(message.getMessage_sender_name());
            System.out.println(message.getMessage_content());
            System.out.println(message.getMessage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String messageLists = mapper1.writeValueAsString(messageList);
        return messageLists;
    }

    @GetMapping(value = "/forum_AllMessage_list")
    @ResponseBody
    public String getForum_All_Message(@RequestParam("message_content_id") Integer message_content_id) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的messageDao
        //映射器是一些绑定映射语句的接口。映射器实例
        Forum_MessageDao mapper = sqlSession.getMapper(Forum_MessageDao.class);
        //可以调用mapper的方法
        List<Forum_Message> messageList = mapper.getAllForum_MessageList(message_content_id);
        for (Forum_Message message : messageList) {
            System.out.print(message.getMessage_id());
            System.out.print(message.getMessage_content_id());
            System.out.println(message.getMessage_sender_name());
            System.out.println(message.getMessage_content());
            System.out.println(message.getMessage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String messageLists = mapper1.writeValueAsString(messageList);
        return messageLists;
    }

    @PostMapping("/forum_message_add")
    @ResponseBody
    public String addForum_One_Message(@RequestBody Forum_Message forum_message) throws JsonProcessingException {
//    public String addForum_One_Message(@RequestParam("forum_message_name") String forum_name,@RequestParam("forum_pwd") String forum_pwd,@RequestParam("forum_email") String forum_email) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的messageDao
        Forum_MessageDao mapper = sqlSession.getMapper(Forum_MessageDao.class);
        //可以调用mapper的方法
//        List<Forum_Message> messageList = mapper.addForum_MessageList(forum_name,forum_pwd,forum_email);
        List<Forum_Message> messageList = mapper.addForum_MessageList(forum_message.getMessage_content_id(),forum_message.getMessage_sender_name(),forum_message.getMessage_content(),forum_message.getMessage_send_time());
        for (Forum_Message message : messageList) {
            System.out.print(message.getMessage_id());
            System.out.print(message.getMessage_content_id());
            System.out.println(message.getMessage_sender_name());
            System.out.println(message.getMessage_content());
            System.out.println(message.getMessage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String messageLists = mapper1.writeValueAsString(messageList);
        return messageLists;
    }

    @RequestMapping("/forum_message_update")
    @ResponseBody
    public String updateSql(@RequestParam("message_id")Integer message_id,@RequestParam("message_content") String message_content) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的messageDao
        Forum_MessageDao mapper = sqlSession.getMapper(Forum_MessageDao.class);
        //可以调用mapper的方法
        List<Forum_Message> messageList = mapper.updateForum_MessageList(message_id,message_content);

        for (Forum_Message message : messageList) {
            System.out.print(message.getMessage_id());
            System.out.print(message.getMessage_content_id());
            System.out.println(message.getMessage_sender_name());
            System.out.println(message.getMessage_content());
            System.out.println(message.getMessage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String messageLists = mapper1.writeValueAsString(messageList);
        return messageLists;
    }

    @RequestMapping("/forum_message_delete")
    public String deleteSql(@RequestParam("message_id") Integer message_id){
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的messageDao
        Forum_MessageDao mapper = sqlSession.getMapper(Forum_MessageDao.class);
        //可以调用mapper的方法
        List<Forum_Message> messageList = mapper.deleteForum_MessageList(message_id);
        for (Forum_Message message : messageList) {
            System.out.print(message.getMessage_id());
            System.out.print(message.getMessage_content_id());
            System.out.println(message.getMessage_sender_name());
            System.out.println(message.getMessage_content());
            System.out.println(message.getMessage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

}
