package com.springboot.hello.service.impl;

import com.springboot.hello.dto.ProductDto;
import com.springboot.hello.dto.ProductResponseDto;
import com.springboot.hello.entity.Product;
import com.springboot.hello.repository.ProductRepository;
import com.springboot.hello.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.ReturnsArgumentAt;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_SELF;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProductServiceTest {
	private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
	private ProductServiceImpl productService;

	@BeforeEach
	public void setUpTest() {
		productService = new ProductServiceImpl(productRepository);
	}

//	@Test
//	void getProductTest() {
//		// given
//		Product givenProduct = new Product();
//		givenProduct.setNumber(123L);
//		givenProduct.setName("펜");
//		givenProduct.setPrice(1000);
//		givenProduct.setStock(1234);
//
//		Mockito.when(productRepository.findById(123L)).thenReturn(Optional.of(givenProduct));
//
//		// when
//		ProductResponseDto productResponseDto = productService.getProduct(123L);
//
//		// then
//		Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
//		Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
//		Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
//		Assertions.assertEquals(productResponseDto.getStock(), givenProduct.getStock());
//
//		verify(productRepository).findById(123L);
//	}

	@Test
    void saveProductTest() {
    	// given
    	Mockito.when(productRepository.save(any(Product.class))).then(AdditionalAnswers.returnsFirstArg());

		// when
    	ProductResponseDto productResponseDto = productService.saveProduct(new ProductDto("펜", 1000, 1234));
    	
    	// then
    	Assertions.assertEquals(productResponseDto.getName(), "펜");
    	Assertions.assertEquals(productResponseDto.getPrice(), 1000);
    	Assertions.assertEquals(productResponseDto.getStock(), 1234);
    	
    	verify(productRepository).save(any());
    }
}