package com.capgemini.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.cartservice.model.Cart;

public interface CartRepository extends MongoRepository<Cart,Integer> {
	

}
