package com.ultragroup.agenciaviaje.repository;

import com.ultragroup.agenciaviaje.model.user.User;

public interface UserRepository {
	
	public User findOne(User user);
}
