package com.cg.eshoppingzone.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eshoppingzone.productservice.entity.Product;
import com.cg.eshoppingzone.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productrepository;

	@Override
	public void addProduct(Product product) {
		productrepository.save(product);	
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productrepository.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		return productrepository.findByproductId(productId);
	}

	@Override
	public Optional<Product> getProductByName(String productName) {
		return productrepository.findByProductName(productName);
	}

	@Override
	public Product updateProduct(Product product) {
		int id = product.getProductId();
		Product productDetails = productrepository.findByproductId(id);
		productDetails.setProductType(product.getProductType());
		productDetails.setDescription(product.getDescription());
		productDetails.setPrice(product.getPrice());
		productDetails.setProductName(product.getProductName());
		productDetails.setCategory(product.getCategory());
		productDetails.setImage(product.getImage());
		return productrepository.save(productDetails);
		
	}

	@Override
	public Product deleteProductById(int productId) {
		// TODO Auto-generated method stub
		return productrepository.deleteByproductId(productId);
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		return productrepository.findByCategory(category);
	}

	@Override
	public List<Product> getProductByType(String productType) {
		return productrepository.findByProductType(productType);
	}


}
