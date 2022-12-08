package com.example.pojo;

public class Book {
    private Integer bookId;
    private Integer userPublishId;
    private String bookName;
    private String ISBN;
    private String bookTypes;
    private String imageURL;
    private Integer isSold;

    public Book(Integer bookId, Integer userPublishId, String bookName, String ISBN, String bookTypes, String imageURL, Integer isSold) {
        this.bookId = bookId;
        this.userPublishId = userPublishId;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.bookTypes = bookTypes;
        this.imageURL = imageURL;
        this.isSold = isSold;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserPublishId() {
        return userPublishId;
    }

    public void setUserPublishId(Integer userPublishId) {
        this.userPublishId = userPublishId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTypes() {
        return bookTypes;
    }

    public void setBookTypes(String bookTypes) {
        this.bookTypes = bookTypes;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getIsSold() {
        return isSold;
    }

    public void setIsSold(Integer isSold) {
        this.isSold = isSold;
    }

}
