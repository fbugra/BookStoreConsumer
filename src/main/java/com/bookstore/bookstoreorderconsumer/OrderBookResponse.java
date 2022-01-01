package com.bookstore.bookstoreorderconsumer;

public class OrderBookResponse {

    public Status status;

    public OrderBookResponse(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status{
        ORDERED,
        DENIED
    }
}
