package com.eshoppingzone.profileservice.service;

import java.util.List;

import com.eshoppingzone.profileservice.model.Role;
import com.eshoppingzone.profileservice.model.UserProfile;

public interface ProfileService {
	public Role createNewRole(Role role);
	public UserProfile registerNewUser(UserProfile user);

		public List<UserProfile> getAllProfiles();
		public void updateProfile(UserProfile userProfile);
		public UserProfile deleteProfile(int profileId);
		public void addNewMerchantProfile(UserProfile userProfile);
		public void addNewdeliveryProfile(UserProfile userProfile);
		public UserProfile findByMobileNo(Long mobileNumber);
		public UserProfile getByUserName(String fullName);
		public UserProfile getByProfileId(int profileId);

	}


