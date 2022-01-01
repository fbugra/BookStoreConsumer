package com.bookstore.bookstoreorderconsumer;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookStoreOrderController {

    private final RestTemplate restTemplate;

    public BookStoreOrderController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @PostMapping("/order-book")
    public OrderBookResponse orderBook(final OrderBookRequest orderBookRequest){
        final int bookId = orderBookRequest.getBookId();
        final String bookName = orderBookRequest.getBookName();
        CheckBookResponse checkBookResponse =restTemplate.postForObject("http:localhost:8080/order-book", new CheckBookRequest(bookId), CheckBookResponse.class);
        if(checkBookResponse.status.equals(CheckBookResponse.Status.AVAILABLE)){
            return new OrderBookResponse(OrderBookResponse.Status.ORDERED);
        }
        return new OrderBookResponse(OrderBookResponse.Status.DENIED);

    }
}
