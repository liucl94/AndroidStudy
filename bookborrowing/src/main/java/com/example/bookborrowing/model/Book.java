package com.example.bookborrowing.model;

import java.util.Date;

public class Book {
    private String bookName;
    private int bookPictrue;
    private int applicableAge;
    private boolean isHistory;
    private boolean isSuspense;
    private boolean isArt;
    private Date borrowingTime;

    public Book(String bookName, int bookPictrue, int applicableAge, boolean isHistory, boolean isSuspense, boolean isArt, Date borrowingTime) {
        this.bookName = bookName;
        this.bookPictrue = bookPictrue;
        this.applicableAge = applicableAge;
        this.isHistory = isHistory;
        this.isSuspense = isSuspense;
        this.isArt = isArt;
        this.borrowingTime = borrowingTime;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPictrue() {
        return bookPictrue;
    }

    public void setBookPictrue(int bookPictrue) {
        this.bookPictrue = bookPictrue;
    }

    public int getApplicableAge() {
        return applicableAge;
    }

    public void setApplicableAge(int applicableAge) {
        this.applicableAge = applicableAge;
    }

    public boolean isHistory() {
        return isHistory;
    }

    public void setHistory(boolean history) {
        isHistory = history;
    }

    public boolean isSuspense() {
        return isSuspense;
    }

    public void setSuspense(boolean suspense) {
        isSuspense = suspense;
    }

    public boolean isArt() {
        return isArt;
    }

    public void setArt(boolean art) {
        isArt = art;
    }

    public Date getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(Date borrowingTime) {
        this.borrowingTime = borrowingTime;
    }
}
