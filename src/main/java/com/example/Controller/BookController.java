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
    @GetMapping(value = "/bookTypeList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTypeBook(@RequestParam("bookType") String bookType) throws JsonProcessingException {
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
    @ResponseBody
    public String getOneBook(@RequestParam("bookId") Integer bookId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.getOneBookList(bookId);
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

    @RequestMapping("/bookOneUserList")
    @ResponseBody
    public String getOneUserBook(@RequestParam("userPublishId") Integer userPublishId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.getUserBookList(userPublishId);
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

    @RequestMapping("/userNotSoldBookList")
    @ResponseBody
    public String getUserNotSoldBookList(@RequestParam("userPublishId") Integer userPublishId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.getUserNotSoldBookList(userPublishId);
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

    @RequestMapping("/userSoldBookList")
    @ResponseBody
    public String getUserSoldBookList(@RequestParam("userPublishId") Integer userPublishId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.getUserSoldBookList(userPublishId);
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

    @RequestMapping("/bookOneNameList")
    @ResponseBody
    public String getOneNameBook(@RequestParam("bookName") String bookName) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.getOneNameBookList(bookName);
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

    @RequestMapping("/bookNotSoldList")
    @ResponseBody
    public String getAllNotSoldBook() throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.getAllNotSoldBookList();
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

    @RequestMapping("/setBookSold")
    @ResponseBody
    public String setBookSold(@RequestParam("bookId") Integer bookId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.setBookSold(bookId);
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

    @RequestMapping("/setBookNotSold")
    @ResponseBody
    public String setBookNotSold(@RequestParam("bookId") Integer bookId) throws JsonProcessingException {
        //获取sqlSession（mybatis-config读取成功）
        //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //方式一
        //先连接mapper里面的userDao
        //映射器是一些绑定映射语句的接口。映射器实例
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.setBookNotSold(bookId);
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

    @PostMapping("/bookAdd")
    public String addBook(@RequestBody Book book) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一
        //先连接mapper里面的userDao
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
//        System.out.print(book.getBookId());
        System.out.println(book.getBookName());
        System.out.println(book.getISBN());
        System.out.println(book.getText());
        System.out.println(book.getUserPublishId());
        System.out.println(book.getImageURL());
        System.out.println(book.getBookTypes());
        List<Book> BookList = mapper.addBookList(book.getBookName(),
                book.getISBN(),book.getUserPublishId(),book.getBookTypes(),
                book.getImageURL(),book.getText());
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

    @PostMapping("/bookUpdate")
    public String updateBook(@RequestBody Book book) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一
        //先连接mapper里面的userDao
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.updateBookList(book.getBookId(),book.getBookName(), book.getISBN(),book.getBookTypes(), book.getText());
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

    @RequestMapping("/bookDelete")
    public String deleteBook(@RequestParam("book_id")Integer book_id) {
        //获取sqlSession（mybatis-config读取成功）
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一
        //先连接mapper里面的userDao
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        //可以调用mapper的方法
        List<Book> bookList = mapper.deleteBookList(book_id);
        //关闭SqlSession
        sqlSession.close();
        return "index";
    }

}
