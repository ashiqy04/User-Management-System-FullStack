package com.userinfo.service;

import java.util.List;

import com.userinfo.model.User;

public interface UserService {

	User saveUser(User newUser);

	List<User> getAllUsers();

	User getById(Long id);

	User updateUserById(User newUser, Long id);

	String deleteUserById(Long id);

	
	

}
