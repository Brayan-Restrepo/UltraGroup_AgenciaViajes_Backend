package com.ultragroup.agenciaviaje.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ultragroup.agenciaviaje.exception.NotFoundException;
import com.ultragroup.agenciaviaje.model.user.User;
import com.ultragroup.agenciaviaje.service.UserService;

//import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("user")
public class UsersController {

	private static final Log log = LogFactory.getLog(UsersController.class);

	private final UserService usersService;

	private User user;

	@Autowired
	public UsersController(UserService usersService) {
		this.usersService = usersService;
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
//	@ApiOperation(value = "Find an user", notes = "Return a user by Id")
	public ResponseEntity<User> userById(@PathVariable String userId) throws NotFoundException {
		log.info("Get userById");
		try {
			user = usersService.findByUserId(userId);
		} catch (NotFoundException e) {
			user = null;
		}
		return ResponseEntity.ok(user);
	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<User>> userById() {
//		log.info("Get allUsers");
//		return ResponseEntity.ok(usersService.findAll());
//	}

//	@RequestMapping(method = RequestMethod.GET)
//	@ApiOperation(value = "Find all user", notes = "Return all users")
//	public ResponseEntity<List<User>> userById() {
//		log.info("Get allUsers");
//		return ResponseEntity.ok(usersService.findAll());
//	}
//
//	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
//	@ApiOperation(value = "Delete an user", notes = "Delete a user by Id")
//	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
//		log.info("Delete user " + userId);
//		usersService.deleteUser(userId);
//		return ResponseEntity.noContent().build();
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	@ApiOperation(value = "Create an user", notes = "Create a new user")
//	public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
//		log.info("Save new user");
//		return ResponseEntity.ok(usersService.saveUser(user));
//	}
}
