package com.example.pojo;

public class Information {
    private Integer transactionId;
    private Integer bookId;
    private Integer sellUserId;
    private Integer buyUserId;
    private String time;

    public Information(Integer transactionId, Integer bookId, Integer sellUserId, Integer buyUserId, String time) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.sellUserId = sellUserId;
        this.buyUserId = buyUserId;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(Integer sellUserId) {
        this.sellUserId = sellUserId;
    }

    public Integer getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(Integer buyUserId) {
        this.buyUserId = buyUserId;
    }
}
