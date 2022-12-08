package com.example.Controller;

import com.example.Utils.MyBatisUtils;
import com.example.dao.BookDao;
import com.example.dao.UserDao;
import com.example.dao.VerificationCodeDao;
import com.example.pojo.Book;
import com.example.pojo.User;
import com.example.pojo.VerificationCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @GetMapping(value = "/bookList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBook(@RequestParam("bookType") String bookType) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.getBookList(bookType);
        for (Book book:bookList) {
            System.out.print(book.getBookId());
            System.out.print(book.getBookName());
            System.out.println(book.getISBN());
            System.out.println(book.getBookTypes());
        }
        //关闭SqlSession
        sqlSession.close();

        ObjectMapper mapper1 = new ObjectMapper();

        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(bookList);
        return s;
    }

    @GetMapping(value = "/allBookList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getBooks() throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.getAllBookList();
        for (Book book:bookList) {
            System.out.print(book.getBookId());
            System.out.print(book.getBookName());
            System.out.println(book.getISBN());
            System.out.println(book.getBookTypes());
        }
        //关闭SqlSession
        sqlSession.close();
        ObjectMapper mapper1 = new ObjectMapper();
        //创建一个对象，将Java对象转换成json对象
        String s = mapper1.writeValueAsString(bookList);
        return s;
    }

    @RequestMapping("/bookOneList")
    public String getOneBook() {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.getOneUserList(1);
        for (User user : userList) {
            System.out.print(user.getId());
            System.out.print(user.getName());
            System.out.println(user.getPwd());
        }
        //关闭SqlSession
        sqlSession.close();
        return "redirect:/index.html";
    }

    @PostMapping("/bookAdd")
    public String addBook(String book_name,String ISBN,Integer userId,String bookType) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一
        //先连接mapper里面的userDao
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
//        List<Book> BookList = mapper.addBookList(book_name,ISBN,userId,bookType);
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

//    @RequestMapping("/bookUpdate")
//    public String updateBook() {
//        //获取sqlSession（mybatis-config读取成功）
//        SqlSession sqlSession = MyBatisUtils.getSqlSession();
//
//        //方式一
//        //先连接mapper里面的userDao
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
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

    @RequestMapping("/bookDelete")
    public String deleteBook(@RequestParam("book_id")Integer book_id) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //可以调用mapper的方法
        List<User> userList = mapper.deleteUserList(book_id);
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
