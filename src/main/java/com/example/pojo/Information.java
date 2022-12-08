package com.example.pojo;

public class Information {
    private Integer transactionId;
    private enum Position{
        JiangAn,WangJiang,HuaXi;
    }
    private String sendUserId;
    private String releaseUserId;
    private Integer bookId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setUserPosition(String userPosition) {
        if (Information.Position.JiangAn.toString() == userPosition)
            System.out.println("江安校区");
        if (Information.Position.WangJiang.toString() == userPosition)
            System.out.println("望江校区");
        if (Information.Position.HuaXi.toString() == userPosition)
            System.out.println("华西校区");
    }

    public Information(Integer transactionId, String sendUserId, String releaseUserId, Integer bookId) {
        this.transactionId = transactionId;
        this.sendUserId = sendUserId;
        this.releaseUserId = releaseUserId;
        this.bookId = bookId;
    }

    public Information(Integer transactionId, String sendUserId, String releaseUserId) {
        this.transactionId = transactionId;
        this.sendUserId = sendUserId;
        this.releaseUserId = releaseUserId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getReleaseUserId() {
        return releaseUserId;
    }

    public void setReleaseUserId(String releaseUserId) {
        this.releaseUserId = releaseUserId;
    }
}
