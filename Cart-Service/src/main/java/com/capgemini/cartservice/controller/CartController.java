package com.capgemini.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cartservice.model.Cart;
import com.capgemini.cartservice.repository.CartRepository;
import com.capgemini.cartservice.service.CartService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	CartRepository cartRepository;
	
	@GetMapping("/getproducts")
	public List<Cart> getCart() {
		return cartService.getAllCartItems();
	}
	
	@PostMapping("/add")
	public void addCart(@RequestBody Cart cart) {
		cartService.addCart(cart);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteproduct(@PathVariable("id") int id) {
        return cartRepository.findById(id)
                .map(cart -> {
                    cartRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    }
	

	
	
	


	


