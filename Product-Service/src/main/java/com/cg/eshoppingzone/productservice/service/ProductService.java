package com.cg.eshoppingzone.productservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.eshoppingzone.productservice.entity.Product;

public interface ProductService {
	public void addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(int productId);
	public Optional<Product> getProductByName(String productName);
	public Product updateProduct(Product product);
	public Product deleteProductById(int productId);
	public List<Product> getProductByCategory(String category);
	public List<Product> getProductByType(String productType);
	

}
