package com.bootexample4.products;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;

@SpringBootTest
class ProductsApplicationTests {

	@Autowired
    private ProductRepository productRepo;

	@Test
	public void testCreate() {
		Product p=new Product();
		p.setName("product-1");
		p.setPrice(34.68);
		p.setDescription("video game");
		
		TestMockServer.createExpectationForAddNewProduct(p,200,"127.0.0.1",3000);

		// productRepo.save(p);
		assertNotNull(productRepo.findById(1L).get());
		// System.out.println(p);
	}

}
