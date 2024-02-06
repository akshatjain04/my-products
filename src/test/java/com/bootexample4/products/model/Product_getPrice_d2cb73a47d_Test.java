// ********RoostGPT********
/*
Test generated by RoostGPT for test MiniProjects using AI Type Azure Open AI and AI Model roost-gpt4-32k

Test Scenario 1: 
Description: Test getPrice() function with positive price value.
Steps: 
1. Initialize an object with a positive price value.
2. Call the getPrice() function.
3. Check the returned price value equals the initially set price value.

Test Scenario 2: 
Description: Test getPrice() function with negative price value.
Steps: 
1. Initialize an object with a negative price value.
2. Call the getPrice() function.
3. Check the returned price value equals the initially set price value.

Test Scenario 3: 
Description: Test getPrice() function with zero price value.
Steps: 
1. Initialize an object with price value as zero.
2. Call the getPrice() function.
3. Check the returned price value is zero.

Test Scenario 4: 
Description: Test getPrice() function with maximum possible price value.
Steps: 
1. Initialize an object with price value as maximum possible double value.
2. Call the getPrice() function.
3. Check the returned price value equals the initially set price value.

Test Scenario 5: 
Description: Test getPrice() function with minimum possible price value.
Steps: 
1. Initialize an object with price value as minimum possible double value.
2. Call the getPrice() function.
3. Check the returned price value equals the initially set price value.
*/

// ********RoostGPT********
package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Product_getPrice_d2cb73a47d_Test{

    private Product product;

    @BeforeEach
    public void setUp(){
        product = new Product();
    }

    @Test
    public void testGetPrice_withPositivePrice(){
        product.setPrice(5000.75);
        double expected = 5000.75;
        double actual = product.getPrice();
        assertEquals(actual, expected);
    }

    @Test
    public void testGetPrice_withNegativePrice(){
        product.setPrice(-5000.75);
        double expected = -5000.75;
        double actual = product.getPrice();
        assertEquals(actual, expected);
    }

    @Test
    public void testGetPrice_withZeroPrice(){
        product.setPrice(0);
        double expected = 0;
        double actual = product.getPrice();
        assertEquals(actual, expected);
    }

    @Test
    public void testGetPrice_withMaxPossibleValue(){
        product.setPrice(Double.MAX_VALUE);
        double expected = Double.MAX_VALUE;
        double actual = product.getPrice();
        assertEquals(actual, expected);
    }

    @Test
    public void testGetPrice_withMinPossibleValue(){
        product.setPrice(Double.MIN_VALUE);
        double expected = Double.MIN_VALUE;
        double actual = product.getPrice();
        assertEquals(actual, expected);
    }
}
