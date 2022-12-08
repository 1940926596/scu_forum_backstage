package com.example.demo;

import com.example.Utils.MyBatisUtils;
import com.example.dao.Forum_MessageDao;
import com.example.pojo.Forum_Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的messageDao
        //映射器是一些绑定映射语句的接口。
        Forum_MessageDao mapper = sqlSession.getMapper(Forum_MessageDao.class);
        //可以调用mapper的方法

        List<Forum_Message> messageList = mapper.getForum_MessageList();
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String messageLists = mapper1.writeValueAsString(messageList);
    }

}
