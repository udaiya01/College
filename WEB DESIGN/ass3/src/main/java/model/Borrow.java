package model;

import java.util.Date;

public class Borrow {
    private String username;
    private String bookId;
    private Date borrowDate;

    public Borrow(String username, String bookId) {
        this.username = username;
        this.bookId = bookId;
        this.borrowDate = new Date();
    }

    public String getUsername() { return username; }
    public String getBookId() { return bookId; }
    public Date getBorrowDate() { return borrowDate; }
}