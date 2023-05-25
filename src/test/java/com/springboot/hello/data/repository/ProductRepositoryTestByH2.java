package com.springboot.hello.data.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Primary;

import com.springboot.hello.entity.Product;
import com.springboot.hello.repository.ProductRepository;


// 인메모리상에 저장
@DataJpaTest
public class ProductRepositoryTestByH2 {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void selectTest() {
		// given
		Product product = new Product();
		product.setName("펜");
		product.setPrice(1000);
		product.setStock(1000);
		
		Product savedProduct = productRepository.saveAndFlush(product);
		
		// when
		Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();
		
		// then
		assertEquals(product.getName(), foundProduct.getName());
		assertEquals(product.getPrice(), foundProduct.getPrice());
		assertEquals(product.getStock(), foundProduct.getStock());
	}
	
	@Test
	void saveTest() {
		
		Product product = new Product();
		product.setName("펜");
		product.setPrice(1000);
		product.setStock(1000);
		
		Product savedProduct = productRepository.save(product);
		
		assertEquals(product.getName(), savedProduct.getName());
		assertEquals(product.getPrice(), savedProduct.getPrice());
		assertEquals(product.getStock(), savedProduct.getStock());
	}
}
