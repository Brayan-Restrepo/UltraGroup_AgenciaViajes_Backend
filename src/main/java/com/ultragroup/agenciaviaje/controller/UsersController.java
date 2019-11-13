package com.ultragroup.agenciaviaje.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ultragroup.agenciaviaje.exception.NotFoundException;
import com.ultragroup.agenciaviaje.model.user.User;
import com.ultragroup.agenciaviaje.service.UserService;


@CrossOrigin("*")
@RestController
@RequestMapping("login")
public class UsersController {

	private static final Log log = LogFactory.getLog(UsersController.class);

	private final UserService usersService;

	@Autowired
	public UsersController(UserService usersService) {
		this.usersService = usersService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> userById(@RequestBody User user) throws NotFoundException {
		log.info("Get userById");
		User responseUser = usersService.findByUser(user);
		if (responseUser != null) {
			return ResponseEntity.ok(user);			
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
