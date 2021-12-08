package com.cg.eshoppingzone.productservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.eshoppingzone.productservice.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String>{
	
	public Optional<Product> findByProductName(String name);
	public List<Product> findByCategory(String Category);
	public List<Product> findByProductType(String type);
	public Product findByproductId(int productId);
	public Product deleteByproductId(int productId);
	
}
