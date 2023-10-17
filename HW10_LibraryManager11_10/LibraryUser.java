package org.example.HW_11_10_23LibraryManager;

import java.util.List;

public class LibraryUser {
    private String userId;
    private String userName;
    private String userEmail;
    private int userPhone;
    private List<Book> userBooksBorrowed;
    private List<Book> userBooksReserved;

    public LibraryUser(String userId, String userName, String userEmail, int userPhone, List<Book> userBooksBorrowed, List<Book> userBooksReserved) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userBooksBorrowed = userBooksBorrowed;
        this.userBooksReserved = userBooksReserved;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public List<Book> getUserBooksBorrowed() {
        return userBooksBorrowed;
    }

    public List<Book> getUserBooksReserved() {
        return userBooksReserved;
    }

    public void setUserBooksBorrowed(List<Book> userBooksBorrowed) {
        this.userBooksBorrowed = userBooksBorrowed;
    }

    public void setUserBooksReserved(List<Book> userBooksReserved) {
        this.userBooksReserved = userBooksReserved;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone=" + userPhone +
                ", userBooksBorrowed=" + userBooksBorrowed +
                ", userBooksReserved=" + userBooksReserved +
                '}';
    }
}
