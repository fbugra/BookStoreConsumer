package com.bookstore.bookstoreorderconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookstoreOrderConsumerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void orderBook() throws Exception {
		mockMvc.perform(
						post("/order-book")
								.contentType(APPLICATION_JSON)
								.content("{" +
										"\"bookId\": 1," +
										"\"bookName\": \"GODFATHER\"" +
										"}"
								))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content()
						.json("{" +
								"\"status\":\"ORDERED\"" +
								"}"))
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
	}

}
