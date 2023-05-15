package com.bootexample4.products.cucumber;

import com.bootexample4.products.controller.ProductController;
import com.bootexample4.products.model.Product;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductStepDefinitions {

    @Autowired
    private ProductController productController;

    private ResponseEntity<Product> getProductByIdResponse;
    private ResponseEntity<Product> updateProductResponse;
    private ResponseEntity<Object> deleteProductResponse;
    private List<Product> listOfProducts;
    private Product newProduct;
    private Product savedProduct;
    private String baseURL;
    private HttpStatusCode responseStatusCode;

    public void unmarshalDataTable(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        newProduct=new Product();
        // Access the data and populate the object "Product"
        for (List<String> row : data) {
            String property = row.get(0);
            String value = row.get(1);

            // Set the property value in the object "Product"
            switch (property) {
                case "name":
                    newProduct.setName(value);
                    break;
                case "description":
                newProduct.setDescription(value);
                    break;
                case "price":
                    double price = Double.parseDouble(value);
                    newProduct.setPrice(price);
                    break;
            }
        }

    }

public Long getProductIDfromAPI(String string){
    int sizeOfInputString = string.length();
    char lastCharOfInputString=string.charAt(sizeOfInputString-1);
    assertTrue((lastCharOfInputString>='0')&&(string.charAt(sizeOfInputString-1)<='9'));
    Long id=(long) (lastCharOfInputString-'0');
    return id;
}

    
@Given("the base URL is {string}")
public void the_base_url_is(String string) {
    // Write code here that turns the phrase above into concrete actions
    baseURL=string;
    System.out.println("the base URL is: "+baseURL);
}

    @When("the client sends a GET request {string} to get the list of all products")
    public void the_client_sends_a_get_request_to_get_the_list_of_all_products(String string) {
        listOfProducts = productController.getAllProducts();
    }

    @Then("the list of products returned should be empty")
    public void the_list_of_products_returned_should_be_empty() {
        assertEquals(0,listOfProducts.size());
    }

    @Given("the client provides the following product data:")
public void the_client_provides_the_following_product_data(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType
    
    unmarshalDataTable(dataTable);
   
}
@When("the client sends a POST request to {string}")
public void the_client_sends_a_post_request_to(String string) {
    // Write code here that turns the phrase above into concrete actions
    savedProduct = productController.createProduct(newProduct);
   
}
@Then("the saved product should not be null and its properties must correspond to those provided by client")
public void the_saved_product_should_not_be_null_and_its_properties_must_correspond_to_those_provided_by_client() {
    // Write code here that turns the phrase above into concrete actions
    assertNotNull(savedProduct);
    assertEquals( newProduct.getPrice(),savedProduct.getPrice(),.001);
    assertEquals(savedProduct.getName(), newProduct.getName(), "unexpected product name: "+savedProduct.getName());
    assertEquals(savedProduct.getDescription(), newProduct.getDescription(), "unexpected product name: "+savedProduct.getDescription());
}

@Given("there is an existing product with ID {long}")
public void there_is_an_existing_product_with_id(Long id) {
    // Write code here that turns the phrase above into concrete actions
    listOfProducts = productController.getAllProducts();
    boolean productPresentFlag = false;
    for (Product product : listOfProducts) {
        if (product.getId()==id){
            productPresentFlag=true;
            break;
        }
    }
    assertTrue(productPresentFlag);
}
@When("the client sends a GET request {string} to get a product by its id")
public void the_client_sends_a_GET_request_to_get_a_product_by_its_id(String string) {
    // Write code here that turns the phrase above into concrete actions
    Long id=getProductIDfromAPI(string);
    getProductByIdResponse=productController.getProductById(id);
    responseStatusCode= getProductByIdResponse.getStatusCode();
}
@Then("the response status code should be {int}")
public void the_response_status_code_should_be(Integer expectedStatusCode) {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(expectedStatusCode,  responseStatusCode.value());
}
@Then("the response should contain the product with ID {long}")
public void the_response_should_contain_the_product_with_id(Long id) {
    // Write code here that turns the phrase above into concrete actions
        Product product = getProductByIdResponse.getBody();
        assertEquals(id, product.getId());
 }

 
@When("the client sends a PUT request to {string}")
public void the_client_sends_a_put_request_to(String string) {
    // Write code here that turns the phrase above into concrete actions
   updateProductResponse= productController.updateProduct(getProductIDfromAPI(string), newProduct);
   responseStatusCode=updateProductResponse.getStatusCode();
}
@Then("the product with ID {long} should be updated with the provided details")
public void  the_product_with_ID_should_be_updated_with_the_provided_details(Long id) {
    // Write code here that turns the phrase above into concrete actions
    Product updatedProduct = productController.getProductById(id).getBody();
    assertEquals(newProduct.getDescription(), updatedProduct.getDescription());
    assertEquals(newProduct.getName(), updatedProduct.getName());
    assertEquals(newProduct.getPrice(), updatedProduct.getPrice());
}

@When("the client sends a DELETE request to {string}")
public void the_client_sends_a_delete_request_to(String string) {
    // Write code here that turns the phrase above into concrete actions
    Long id = getProductIDfromAPI(string);
    deleteProductResponse=productController.deleteProduct(id);
    responseStatusCode=deleteProductResponse.getStatusCode();
}
@Then("the product with ID {long} should no longer exist")
public void the_product_with_id_should_no_longer_exist(Long id) {
    // Write code here that turns the phrase above into concrete actions
    getProductByIdResponse =productController.getProductById(id);
    assertEquals(HttpStatus.NOT_FOUND,getProductByIdResponse.getStatusCode());
}


}
   