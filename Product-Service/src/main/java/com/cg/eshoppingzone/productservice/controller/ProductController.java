package com.cg.eshoppingzone.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eshoppingzone.productservice.entity.Product;
import com.cg.eshoppingzone.productservice.service.ProductService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/getproducts")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/addproducts")
	public void addNewProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@GetMapping("/getbyid/{id}")
	public Product getProductById(@PathVariable("id") int productId){
		return productService.getProductById(productId);
	}
	
	@GetMapping("/getbyname/{name}")
	public Optional<Product> getProductByName(@PathVariable("name") String productName){
		return productService.getProductByName(productName);
	}
	
	@PutMapping("/updateproduct")
	public Product updateDetailsById(@RequestBody Product product) {
		return productService.updateProduct( product);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public Product deleteProductById(@PathVariable("id") int productId){
		return productService.deleteProductById(productId);
	}
	
	@GetMapping("/getbycategory/{category}")
	public List<Product> getProductByCategory(@PathVariable("category") String category){
		return productService.getProductByCategory(category);
	}
	
	@GetMapping("getbytype/{type}")
	public List<Product> getProductByType(@PathVariable("type") String productType){
		return productService.getProductByType(productType);
	}
}