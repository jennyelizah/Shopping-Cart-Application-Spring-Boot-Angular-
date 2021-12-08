package com.cg.eshoppingzone.productservice;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.eshoppingzone.productservice.entity.Product;
import com.cg.eshoppingzone.productservice.repository.ProductRepository;
import com.cg.eshoppingzone.productservice.service.ProductService;



@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {
	
	@Autowired
	private ProductService productservice;
	
	@MockBean
	private ProductRepository repository;
	
	@Test
	public void getAllProductsTest() {
		when(repository.findAll()).thenReturn(Stream.of
			(new Product(12,"clothes","skirt","dresses",5,"love the color","",3000,"have a lovely day","color:red"),
			new Product(15,"shoes","nike shoes","footwear",3,"very comfortable","",5000,"have a sporty day","color:black")).collect(Collectors.toList()));
	assertEquals(2,productservice.getAllProducts().size());
	}
	
	@Test
	public void saveProductTest() {
		Product product=new Product(15,"phone","mi","electronics",4,"easy to use","",3500,"amazing day","color:black");
		productservice.addProduct(product);
		verify(repository,times(1)).save(product);
	}
	
	@Test
	public void getproductById() {
		when(repository.findByproductId(12)).thenReturn(new Product(12,"clothes","skirt","dresses",5,"love the color","",3000,"have a lovely day","color:red"));
		Product prod=productservice.getProductById(12);
		assertEquals(12,prod.getProductId());
	}
	


}
