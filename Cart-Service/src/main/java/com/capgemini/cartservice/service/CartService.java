package com.capgemini.cartservice.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.cartservice.model.Cart;

public interface CartService {
	public List<Cart> getAllCartItems();
	public double cartTotal(Cart cart);
	public void addCart(Cart cart);
	

	

}
