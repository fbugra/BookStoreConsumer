package com.bookstore.bookstoreorderconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class BookStoreOrderController {

    @Autowired
    private final RestTemplate restTemplate;

    public BookStoreOrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @PostMapping(value = "/order-book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BuyBookResponse orderBook(@RequestBody BuyBookRequest buyBookRequest) throws IOException {

        GetAvailableBookResponse getAvailableBookResponse = restTemplate.postForObject("http://localhost:8080/get-available-book-count", new GetAvailableBookRequest(buyBookRequest.getBookId()), GetAvailableBookResponse.class);
        if(getAvailableBookResponse.getCount()>0)
                return new BuyBookResponse(BuyBookResponse.Status.ACCEPTED);

        return new BuyBookResponse(BuyBookResponse.Status.REJECTED);

    }

}
