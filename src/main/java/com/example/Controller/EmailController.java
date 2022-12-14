package com.example.Controller;

import com.example.Service.Verification;
import com.example.Utils.MyBatisUtils;
import com.example.dao.VerificationCodeDao;
import com.example.pojo.User;
import com.example.pojo.VerificationCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Controller
public class EmailController {

    @Resource
    private JavaMailSender javaMailSender;

    //读取yml文件中username的值并赋值给form
    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendSimpleMail(@RequestParam(value = "emailReceiver") String emailReceiver) {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件发送者
        message.setFrom(from);
        // 设置邮件接收者
        message.setTo(emailReceiver);
        // 设置邮件的主题
        message.setSubject("登录验证码");
        // 设置邮件的正文
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(10);
            code.append(r);
        }
        String text = "您的验证码为：" + code + ",请勿泄露给他人。请在60s内完成操作";
        message.setText(text);
        Verification.postVerification(String.valueOf(code),emailReceiver);

        // 发送邮件
        try {
            javaMailSender.send(message);
            return code.toString();
        } catch (MailException e) {
            e.printStackTrace();
        }
        return "发送失败";
    }

    @RequestMapping("/sendSellerSellEmail")
    @ResponseBody
    public String sendSellerSellEmail(@RequestParam(value = "emailReceiver") String emailReceiver) {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件发送者
        message.setFrom(from);
        // 设置邮件接收者
        message.setTo(emailReceiver);
        // 设置邮件的主题
        message.setSubject("校园二手书交易平台");
        // 设置邮件的正文
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(10);
            code.append(r);
        }
        String text = "你的书被发起报价了，请登录网站查看";
        message.setText(text);
//        Verification.SellEmail(String.valueOf(code),emailReceiver);

        // 发送邮件
        try {
            javaMailSender.send(message);
            return code.toString();
        } catch (MailException e) {
            e.printStackTrace();
        }
        return "发送失败";
    }

    @RequestMapping("/sendSellerCancelEmail")
    @ResponseBody
    public String sendSellerCancelEmail(@RequestParam(value = "emailReceiver") String emailReceiver) {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件发送者
        message.setFrom(from);
        // 设置邮件接收者
        message.setTo(emailReceiver);
        // 设置邮件的主题
        message.setSubject("校园二手书交易平台");
        // 设置邮件的正文
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(10);
            code.append(r);
        }
        String text = "你的书报价被撤销了，请登录网站查看";
        message.setText(text);
//        Verification.CancelEmail(String.valueOf(code),emailReceiver);

        // 发送邮件
        try {
            javaMailSender.send(message);
            return code.toString();
        } catch (MailException e) {
            e.printStackTrace();
        }
        return "发送失败";
    }

    @RequestMapping("/saveVerifyCode")
    @ResponseBody
    public String verifyCode() {
        return " ";
    }

    @RequestMapping("/getCodeList")
    @ResponseBody
    public String getCodeList() throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        VerificationCodeDao mapper = sqlSession.getMapper(VerificationCodeDao.class);
        //可以调用mapper的方法
        List<VerificationCode> codeList = mapper.getCodeList();
        for (VerificationCode code : codeList) {
            System.out.println(code.getId());
            System.out.println(code.getCode());
        }
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String codeLists = mapper1.writeValueAsString(codeList);
        return codeLists;
    }

    @RequestMapping("/addCodeList")
    @ResponseBody
    public String addCodeList(@RequestParam("name") String name,@RequestParam("code") String code) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        VerificationCodeDao mapper = sqlSession.getMapper(VerificationCodeDao.class);
        //可以调用mapper的方法
//        VerificationCode vCode=new VerificationCode(name,code);
        List<VerificationCode> codeList = mapper.addCodeList(name,code);
//         mapper.addCodeList(name,code);
        sqlSession.close();
//        System.out.println("aaa");
        ObjectMapper mapper1 = new ObjectMapper();
//        //创建一个对象，将Java对象转换成json对象
        String codeLists = mapper1.writeValueAsString(codeList);
        return codeLists;
    }
}
