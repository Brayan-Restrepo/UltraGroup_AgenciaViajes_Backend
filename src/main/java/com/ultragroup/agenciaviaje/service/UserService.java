package com.ultragroup.agenciaviaje.service;

import java.util.List;

import com.ultragroup.agenciaviaje.model.user.User;

public interface UserService {

	public List<User> findAll();
	public User findByUserId(String userId);
	public User saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(String userId);
}
