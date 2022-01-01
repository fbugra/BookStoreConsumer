package com.bookstore.bookstoreorderconsumer;

public class CheckBookResponse {

    public Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status{
        AVAILABLE,
        ORDERED,
        INAVAILABLE
    }
}
