package com.example.dao;
import com.example.pojo.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface BookDao {
    List<Book> getBookList(String bookType);
    List<Book> getAllBookList();
    List<Book> getOneBookList(Integer bookId);
    List<Book> getOneNameBookList(String bookName);
    List<Book> getAllNotSoldBookList(Integer isSold);
    List<Book> addBookList(String book_name,String ISBN,Integer userId,String bookType,String imageURL);
    List<Book> updateBookList(Integer bookId,String book_name,String ISBN,String bookType);
    List<Book> deleteBookList(Integer bookId);
}
