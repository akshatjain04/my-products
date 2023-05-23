package com.bootexample4.products;

import org.mockserver.client.server.MockServerClient;
import java.util.concurrent.TimeUnit;

import org.mockserver.matchers.Times;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import com.bootexample4.products.model.Product;

public class TestMockServer {
    
    public static void createExpectationForAddNewProduct(Product p, int statuscode,String host, int port ) {
        new MockServerClient(host, port, "/mockserver")
		.when(
			HttpRequest.request(null)
			.withMethod("POST")
			.withPath("/api/products").
			withHeader("\"Content-type\", \"application/json\"")
			.withBody(p.toString()), 
			Times.exactly(1))
			.respond(
				HttpResponse.response()
			.withStatusCode(statuscode)
			.withHeaders(
				new Header("Content-Type", "application/json; charset=utf-8"),
				new Header("Cache-Control", "public, max-age=86400")
				)
			.withBody("successfully added product")
			.withDelay(TimeUnit.SECONDS,1)
				);
    }
}

//""
