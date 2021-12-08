package com.eshoppingzone.profileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eshoppingzone.profileservice.model.Role;

public interface RoleRepository extends MongoRepository<Role, String>{

}
