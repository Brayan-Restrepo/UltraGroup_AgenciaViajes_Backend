package com.ultragroup.agenciaviaje.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.ultragroup.agenciaviaje.model.user.User;
import com.ultragroup.agenciaviaje.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private final MongoOperations mongoOperations;
	
	@SuppressWarnings("deprecation")
	public UserRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mongoOperations = mongoOperations;
	}


    public Optional<User> findOne(String userId) {

        User d = this.mongoOperations.findOne(new Query(Criteria.where("userId").is(userId)), User.class);

        Optional<User> user = Optional.ofNullable(d);

        return user;

    }
	
	@Override
	public Optional<List<User>> findAll() {
    	List<User> users = this.mongoOperations.find(new Query(), User.class);
        Optional<List<User>> optionalUsers = Optional.ofNullable(users);
        return optionalUsers;
	}

	@Override
	public User saveUser(User user) {
        this.mongoOperations.save(user);
        return findOne(user.getUserId()).get();
	}

	@Override
	public void updateUser(User user) {
        this.mongoOperations.save(user);
	}

	@Override
	public void deleteUser(String userId) {
		this.mongoOperations.findAndRemove(new Query(Criteria.where("userId").is(userId)), User.class);
	}

}
