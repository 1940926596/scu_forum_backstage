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
    @GetMapping(value = "/informationList", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getInformationList() throws JsonProcessingException {
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
            System.out.println(information.getBookId());
            System.out.println(information.getTransactionId());
            System.out.println(information.getBuyUserId());
            System.out.println(information.getSellUserId());
            System.out.println(information.getTime());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(informationList);
        return s;
    }

    @RequestMapping("/informationOneList")
    @ResponseBody
    public String getOneInformationList(@RequestParam("transactionId") Integer transactionId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
        //可以调用mapper的方法
        List<Information> informationList = mapper.getOneInformationList(transactionId);
        for (Information information : informationList) {
            System.out.println(information.getBookId());
            System.out.println(information.getTransactionId());
            System.out.println(information.getBuyUserId());
            System.out.println(information.getSellUserId());
            System.out.println(information.getTime());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(informationList);
        return s;
    }

    @RequestMapping("/informationOneSellList")
    @ResponseBody
    public String getOneUserSellInformationList(@RequestParam("sellUserId") Integer sellUserId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
        //可以调用mapper的方法
        List<Information> informationList = mapper.getOneUserSellInformationList(sellUserId);
        for (Information information : informationList) {
            System.out.println(information.getBookId());
            System.out.println(information.getTransactionId());
            System.out.println(information.getBuyUserId());
            System.out.println(information.getSellUserId());
            System.out.println(information.getTime());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(informationList);
        return s;
    }

    @RequestMapping("/informationOneBuyList")
    @ResponseBody
    public String getOneUserBuyInformationList(@RequestParam("buyUserId") Integer buyUserId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
        //可以调用mapper的方法
        List<Information> informationList = mapper.getOneUserBuyInformationList(buyUserId);
        for (Information information : informationList) {
            System.out.println(information.getBookId());
            System.out.println(information.getTransactionId());
            System.out.println(information.getBuyUserId());
            System.out.println(information.getSellUserId());
            System.out.println(information.getTime());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(informationList);
        return s;
    }

    @RequestMapping("/informationAdd")
    @ResponseBody
    public String addSql(@RequestBody Information information) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
        //可以调用mapper的方法
        List<Information> informationList = mapper.addInformationList(information.getBookId(), information.getSellUserId(), information.getBuyUserId(), information.getTime());
        for (Information information1 : informationList) {
            System.out.println(information1.getBookId());
            System.out.println(information1.getTransactionId());
            System.out.println(information1.getBuyUserId());
            System.out.println(information1.getSellUserId());
            System.out.println(information1.getTime());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(informationList);
        return s;
    }

    @RequestMapping("/InformationDelete")
    @ResponseBody
    public String deleteSql(@RequestParam("transactionId") Integer transactionId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        InformationDao mapper = sqlSession.getMapper(InformationDao.class);
        //可以调用mapper的方法
        List<Information> informationList = mapper.deleteInformationList(transactionId);
        for (Information information1 : informationList) {
            System.out.println(information1.getBookId());
            System.out.println(information1.getTransactionId());
            System.out.println(information1.getBuyUserId());
            System.out.println(information1.getSellUserId());
            System.out.println(information1.getTime());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(informationList);
        return s;
    }

}
