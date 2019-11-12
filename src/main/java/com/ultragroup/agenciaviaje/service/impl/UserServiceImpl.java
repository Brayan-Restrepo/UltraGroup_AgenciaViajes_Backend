package com.ultragroup.agenciaviaje.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultragroup.agenciaviaje.exception.NotFoundException;
import com.ultragroup.agenciaviaje.model.user.User;
import com.ultragroup.agenciaviaje.repository.UserRepository;
import com.ultragroup.agenciaviaje.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
        Optional<List<User>> user = userRepository.findAll();
        return user.get();
	}

	@Override
	public User findByUserId(String userId) {

        Optional<User> user = userRepository.findOne(userId);
        System.out.println(user.isPresent());
        if (user.isPresent()) {
            log.debug(String.format("Read userId '{}'", userId));
            return user.get();
        } else {
        	throw new NotFoundException(userId);
        }            
	}

	@Override
	public User saveUser(User user) {
        return userRepository.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
        userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
	}

}
