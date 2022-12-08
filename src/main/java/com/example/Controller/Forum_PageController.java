package com.example.Controller;

import com.example.Utils.MyBatisUtils;
import com.example.dao.Forum_PageDao;
import com.example.pojo.Forum_Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Forum_PageController {
    @GetMapping(value = "/forum_page_list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getForum_Page() throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的pageDao
        //映射器是一些绑定映射语句的接口。
        Forum_PageDao mapper = sqlSession.getMapper(Forum_PageDao.class);
        //可以调用mapper的方法

        List<Forum_Page> pageList = mapper.getForum_PageList();
        for (Forum_Page page : pageList) {
            System.out.print(page.getPage_id());
            System.out.print(page.getPage_sender_id());
            System.out.println(page.getPage_sender_name());
            System.out.println(page.getPage_send_content());
            System.out.println(page.getPage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String pageLists = mapper1.writeValueAsString(pageList);
        return pageLists;
    }

    @GetMapping(value = "/forum_onePage_list")
    @ResponseBody
    public String getForum_One_Page(@RequestParam("forum_page_id") Integer forum_page_id) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的pageDao
        //映射器是一些绑定映射语句的接口。映射器实例
        Forum_PageDao mapper = sqlSession.getMapper(Forum_PageDao.class);
        //可以调用mapper的方法
        List<Forum_Page> pageList = mapper.getOneForum_PageList(forum_page_id);
        for (Forum_Page page : pageList) {
            System.out.print(page.getPage_id());
            System.out.print(page.getPage_sender_id());
            System.out.println(page.getPage_sender_name());
            System.out.println(page.getPage_send_content());
            System.out.println(page.getPage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String pageLists = mapper1.writeValueAsString(pageList);
        return pageLists;
    }

    @GetMapping(value = "/forum_AllPage_list")
    @ResponseBody
    public String getForum_All_Page(@RequestParam("page_sender_id") Integer page_page_id,@RequestParam("page_sender_name")String page_sender_name) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的pageDao
        //映射器是一些绑定映射语句的接口。映射器实例
        Forum_PageDao mapper = sqlSession.getMapper(Forum_PageDao.class);
        //可以调用mapper的方法
        List<Forum_Page> pageList = mapper.getAllForum_PageList(page_page_id,page_sender_name);
        for (Forum_Page page : pageList) {
            System.out.print(page.getPage_id());
            System.out.print(page.getPage_sender_id());
            System.out.println(page.getPage_sender_name());
            System.out.println(page.getPage_send_content());
            System.out.println(page.getPage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String pageLists = mapper1.writeValueAsString(pageList);
        return pageLists;
    }

    @PostMapping("/forum_page_add")
    @ResponseBody
    public String addForum_One_Page(@RequestBody Forum_Page forum_page) throws JsonProcessingException {
//    public String addForum_One_Page(@RequestParam("forum_page_name") String forum_name,@RequestParam("forum_pwd") String forum_pwd,@RequestParam("forum_email") String forum_email) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的pageDao
        Forum_PageDao mapper = sqlSession.getMapper(Forum_PageDao.class);
        //可以调用mapper的方法
//        List<Forum_Page> pageList = mapper.addForum_PageList(forum_name,forum_pwd,forum_email);
        List<Forum_Page> pageList = mapper.addForum_PageList(forum_page.getPage_sender_id(),forum_page.getPage_sender_name(),forum_page.getPage_send_time(),forum_page.getPage_send_content());
        for (Forum_Page page : pageList) {
            System.out.print(page.getPage_id());
            System.out.print(page.getPage_sender_id());
            System.out.println(page.getPage_sender_name());
            System.out.println(page.getPage_send_content());
            System.out.println(page.getPage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String pageLists = mapper1.writeValueAsString(pageList);
        return pageLists;
    }

    @RequestMapping("/forum_page_update")
    @ResponseBody
    public String updateSql(@RequestParam("page_id")Integer page_id,@RequestParam("page_send_content") String page_send_content) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的pageDao
        Forum_PageDao mapper = sqlSession.getMapper(Forum_PageDao.class);
        //可以调用mapper的方法
        List<Forum_Page> pageList = mapper.updateForum_PageList(page_id,page_send_content);

        for (Forum_Page page : pageList) {
            System.out.print(page.getPage_id());
            System.out.print(page.getPage_sender_id());
            System.out.println(page.getPage_sender_name());
            System.out.println(page.getPage_send_content());
            System.out.println(page.getPage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String pageLists = mapper1.writeValueAsString(pageList);
        return pageLists;
    }

    @RequestMapping("/forum_page_delete")
    public String deletePage(@RequestParam("page_id") Integer page_id) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的pageDao
        Forum_PageDao mapper = sqlSession.getMapper(Forum_PageDao.class);
        //可以调用mapper的方法
        List<Forum_Page> pageList = mapper.deleteForum_PageList(page_id);
        for (Forum_Page page : pageList) {
            System.out.print(page.getPage_id());
            System.out.print(page.getPage_sender_id());
            System.out.println(page.getPage_sender_name());
            System.out.println(page.getPage_send_content());
            System.out.println(page.getPage_send_time());
        }
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

}
