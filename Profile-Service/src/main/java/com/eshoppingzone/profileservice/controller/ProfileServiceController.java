package com.eshoppingzone.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.profileservice.model.Role;
import com.eshoppingzone.profileservice.model.UserProfile;
import com.eshoppingzone.profileservice.service.ProfileServiceImpl;

@RestController
public class ProfileServiceController {
	@Autowired
	private ProfileServiceImpl profileService;
	
	@PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return profileService.createNewRole(role);
    }
	
	@PostMapping({"/registerNewUser"})
    public UserProfile registerNewUser(@RequestBody UserProfile user) {
        return profileService.registerNewUser(user);
    }	
	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('user')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
    
    @GetMapping("/getprofiles")
	public List<UserProfile> getProfiles() {
		return profileService.getAllProfiles();
	}
	

	
	
	@GetMapping("/getdetails/{id}")
	public UserProfile getProfilebyId(@PathVariable("id") int profileId) {
		return profileService.getByProfileId(profileId);
	}
	
	@DeleteMapping("/deletedetails/{id}")
	public UserProfile deleteProfilebyId(@PathVariable("id") int profileId) {
		return profileService.deleteProfile(profileId);
	}
	
	@GetMapping("/get/{number}")
	public UserProfile getProfileServicebyNumber(@PathVariable("number") Long mobileNumber) {
		return profileService.findByMobileNo(mobileNumber);
	}
	
	@GetMapping("/getname/{name}")
	public UserProfile getProfileServicebyName(@PathVariable("name") String fullName) {
		return profileService.getByUserName(fullName);
	}
	
	@PutMapping("/updatedetails/{id}")
	public void updateDetailsByprofileId(@RequestBody UserProfile userProfile) {
		profileService.updateProfile( userProfile);
		
	}
}	
