package com.ultragroup.agenciaviaje.repository;

import java.util.List;
import java.util.Optional;

import com.ultragroup.agenciaviaje.model.user.User;

public interface UserRepository {
	
	public Optional<User> findOne(String userId);
	public Optional<List<User>> findAll();
	public User saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(String userId);
}
