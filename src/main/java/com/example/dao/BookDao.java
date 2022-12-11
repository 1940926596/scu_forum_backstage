package com.example.dao;
import com.example.pojo.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface BookDao {
    List<Book> getBookList(String bookType);
    List<Book> getAllBookList();
    List<Book> getUserBookList(Integer userPublishId);
    List<Book> getUserNotSoldBookList(Integer userPublishId);
    List<Book> getUserSoldBookList(Integer userPublishId);
    List<Book> getOneBookList(Integer bookId);
    List<Book> getOneNameBookList(String bookName);
    List<Book> getAllNotSoldBookList();
    List<Book> setBookSold(Integer bookId);
    List<Book> setBookNotSold(Integer bookId);
    List<Book> addBookList(String book_name,String ISBN,Integer userId,String bookType,String imageURL,String text);
    List<Book> updateBookList(Integer bookId,String book_name,String ISBN,String bookType,String text);
    List<Book> deleteBookList(Integer bookId);
}
