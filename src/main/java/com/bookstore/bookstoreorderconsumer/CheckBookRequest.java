package com.bookstore.bookstoreorderconsumer;

public class CheckBookRequest {
    private int bookId;

    public CheckBookRequest(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
