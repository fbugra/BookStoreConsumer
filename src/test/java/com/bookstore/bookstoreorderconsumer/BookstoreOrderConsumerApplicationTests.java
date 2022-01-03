package com.bookstore.bookstoreorderconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"com.bookstore:bookstoreinventoryprovider:+:stubs:8080"},
		stubsMode = StubRunnerProperties.StubsMode.LOCAL)

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
								"\"status\":\"ACCEPTED\"" +
								"}"))
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
	}

}
