package com.bootexample4.products.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDefinitions {

    @Autowired
    private ProductRepository productRepository;

    @org.springframework.boot.test.web.server.LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private Product product;
    private ResponseEntity<Product> response;
    private ResponseEntity<List> responseList;
    private ResponseEntity<Object> responseEntity;

    @Given("a product with name {string}, description {string} and price {double}")
    public void a_product_with_name_description_and_price(String name, String description, Double price) {
        product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
    }

    @When("the client calls POST /api/products")
    public void the_client_calls_POST_api_products() {
        response = restTemplate.postForEntity("http://localhost:" + port + "/api/products", product, Product.class);
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int statusCode) {
        assertEquals(HttpStatus.valueOf(statusCode), response.getStatusCode());
    }

    @Given("the following products")
    public void the_following_products(List<Product> products) {
        productRepository.saveAll(products);
    }

    @When("the client calls GET /api/products")
    public void the_client_calls_GET_api_products() {
        responseList = restTemplate.getForEntity("http://localhost:" + port + "/api/products", List.class);
    }

    @When("the client calls GET /api/products/{int}")
    public void the_client_calls_GET_api_products(int id) {
    	System.out.println("getAPIID:   "+id);
        response = restTemplate.getForEntity("http://localhost:" + port + "/api/products/" + id, Product.class);
    }

    @When("the client calls PUT /api/products/{int}")
    public void the_client_calls_PUT_api_products(int id) {
        restTemplate.put("http://localhost:" + port + "/api/products/" + id, product);
    }

    @Then("the client receives a list of {int} products")
    public void the_client_receives_a_list_of_products(int count) {
        assertEquals(count, responseList.getBody().size());
    }

    @Then("the client receives product name {string}, description {string} and price {double}")
    public void the_client_receives_product_name_description_and_price(String name, String description, Double price) {
        Product productResponse = response.getBody();
        assertEquals(name, productResponse.getName());
        assertEquals(description, productResponse.getDescription());
        assertEquals(price, productResponse.getPrice());
    }

//    @When("the client calls DELETE /api/products/{int}")
//    public void the_client_calls_DELETE_api_products(int id) {
//        responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/products/" + id, 
//            org.springframework.http.HttpMethod.DELETE, null, Object.class);
//    }
//
//    @Then("the product is deleted from the database")
//    public void the_product_is_deleted_from_the_database() {
//        assertEquals(0, productRepository.count());
//    }

}