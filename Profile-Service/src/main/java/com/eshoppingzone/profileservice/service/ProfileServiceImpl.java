package com.eshoppingzone.profileservice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eshoppingzone.profileservice.model.Role;
import com.eshoppingzone.profileservice.model.UserProfile;
import com.eshoppingzone.profileservice.repository.RoleRepository;
import com.eshoppingzone.profileservice.repository.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository profilerepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public UserProfile registerNewUser(UserProfile user) {
		 Role role = roleRepository.findById("user").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        user.setRole(userRoles);
	        user.setPassword(getEncodedPassword(user.getPassword()));
		return profilerepository.save(user);
	}
	
	public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
	

	@Override
	public List<UserProfile> getAllProfiles() {
		return profilerepository.findAll();
	}
	
	@Override
	public UserProfile deleteProfile(int profileId) {
		return profilerepository.deleteByprofileId(profileId);	
		
	}



	
	@Override
	public UserProfile getByProfileId(int profileId) {
		return profilerepository.findByprofileId(profileId);
	}

	@Override
	public void addNewMerchantProfile(UserProfile userProfile) {
		profilerepository.save(userProfile);
		
	}

	@Override
	public void addNewdeliveryProfile(UserProfile userProfile) {
		profilerepository.save(userProfile);
		
	}


	@Override
	public UserProfile findByMobileNo(Long mobileNumber) {		
		return profilerepository.findAllByMobileNumber(mobileNumber);
	}

	@Override
	public UserProfile getByUserName(String fullName) {
		return profilerepository.findByfullName(fullName);
	}



	@Override
	public void updateProfile(UserProfile userProfile) {
		int id=userProfile.getProfileId();
		UserProfile user=profilerepository.findByprofileId(id);
		user.setAddress(userProfile.getAddress());
		user.setAbout(userProfile.getAbout());
		user.setDateOfBirth(userProfile.getDateOfBirth());
		user.setFullName(userProfile.getFullName());
		user.setEmailId(userProfile.getEmailId());
		user.setMobileNumber(userProfile.getMobileNumber());
		user.setPassword(userProfile.getPassword());
		UserProfile updatedDetails=profilerepository.save(user);
		
	}



}
