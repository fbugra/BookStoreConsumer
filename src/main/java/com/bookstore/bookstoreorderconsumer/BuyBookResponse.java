package com.bookstore.bookstoreorderconsumer;

public class BuyBookResponse {

    public Status status;

    public BuyBookResponse(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status{
        ACCEPTED,
        REJECTED
    }
}
