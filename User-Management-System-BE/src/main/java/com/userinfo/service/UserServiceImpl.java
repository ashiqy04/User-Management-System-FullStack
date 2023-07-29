package com.userinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.exception.UserNotFoundException;
import com.userinfo.model.User;
import com.userinfo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User newUser) {
		return userRepository.save(newUser);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
	}

	@Override
	public User updateUserById(User newUser, Long id) {
		return userRepository.findById(id)
				.map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

	@Override
	public String deleteUserById(Long id) {
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
		return "User with id "+id+" has been deleted successfully";
	}

}
	
	

