package com.bookstore.bookstoreorderconsumer;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewRequestBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class BookStoreOrderController {

    @PostMapping(value = "/order-book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BuyBookResponse orderBook(@RequestBody BuyBookRequest buyBookRequest) throws IOException {

        if(buyBookRequest.getBookId() == 1 && "GODFATHER".equals(buyBookRequest.getBookName()))
            return new BuyBookResponse(BuyBookResponse.Status.ACCEPTED);

        return new BuyBookResponse(BuyBookResponse.Status.REJECTED);

    }

}
