package com.springboot.hello.data.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.hello.entity.Product;
import com.springboot.hello.repository.ProductRepository;

@SpringBootTest
public class ProductRepositoryTest2 {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void basicCRUDTest() {
		/* create */
		// given
		//
		Product givenProduct = Product.builder().name("노트").price(1000).stock(500).build();

		// when
		Product savedProduct = productRepository.save(givenProduct);

		// then
		assertThat(savedProduct.getNumber()).isEqualTo(givenProduct.getNumber());
		assertThat(savedProduct.getName()).isEqualTo(givenProduct.getName());
		assertThat(savedProduct.getPrice()).isEqualTo(givenProduct.getPrice());
		assertThat(savedProduct.getStock()).isEqualTo(givenProduct.getStock());

		/* read */
		Product selectProduct = productRepository.findById(savedProduct.getNumber()).orElseThrow(RuntimeException::new);

		// then
		assertThat(selectProduct.getNumber()).isEqualTo(givenProduct.getNumber());
		assertThat(selectProduct.getName()).isEqualTo(givenProduct.getName());
		assertThat(selectProduct.getPrice()).isEqualTo(givenProduct.getPrice());
		assertThat(selectProduct.getStock()).isEqualTo(givenProduct.getStock());
			
		/* update */
		// when
		Product foundProduct = productRepository.findById(selectProduct.getNumber())
				.orElseThrow(RuntimeException::new);
		
		foundProduct.setName("장난감");
		
		Product updatedProduct = productRepository.save(foundProduct);
		
		// then
		assertEquals(updatedProduct.getName(), "장난감");
		
		/* delete */
		// when
		productRepository.delete(updatedProduct);
		
		// then
		assertFalse(productRepository.findById(selectProduct.getNumber()).isPresent());
	}
}
