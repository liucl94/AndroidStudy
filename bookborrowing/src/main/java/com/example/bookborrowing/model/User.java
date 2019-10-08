package com.example.bookborrowing.model;

public class User {
    private String userName;
    private String userSex;
    private int userAge;
    private Book borrowingBook;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Book getBorrowingBook() {
        return borrowingBook;
    }

    public void setBorrowingBook(Book borrowingBook) {
        this.borrowingBook = borrowingBook;
    }
}
