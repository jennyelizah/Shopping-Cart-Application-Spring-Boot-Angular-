package com.eshoppingzone.profileservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eshoppingzone.profileservice.model.UserProfile;



public interface UserRepository extends MongoRepository<UserProfile, Integer>{


	
	public UserProfile findAllByMobileNumber(Long number);
	
	
	
	public UserProfile findByfullName(String name);



	public UserProfile findByprofileId(int Id);



	public UserProfile deleteByprofileId(int Id);



	public Optional<UserProfile> findUserByUserName(String userName);



	
}
