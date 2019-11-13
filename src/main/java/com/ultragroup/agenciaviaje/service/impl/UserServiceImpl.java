package com.ultragroup.agenciaviaje.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultragroup.agenciaviaje.model.user.User;
import com.ultragroup.agenciaviaje.repository.UserRepository;
import com.ultragroup.agenciaviaje.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByUser(User user) {
        return userRepository.findOne(user);
	}

}
