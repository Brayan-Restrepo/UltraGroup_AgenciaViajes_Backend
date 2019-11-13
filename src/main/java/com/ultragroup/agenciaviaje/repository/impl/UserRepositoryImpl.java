package com.ultragroup.agenciaviaje.repository.impl;

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


    public User findOne(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("login").is(user.getLogin()));
		query.addCriteria(Criteria.where("password").is(user.getPassword()));
		return this.mongoOperations.findOne(query, User.class);
    }

}
