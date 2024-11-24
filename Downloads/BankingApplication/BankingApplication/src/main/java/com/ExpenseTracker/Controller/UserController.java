package com.ExpenseTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseTracker.ExpenseService.UserService;
import com.ExpenseTracker.entity.User;
import com.ExpenseTracker.entity.UserModel;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@PostMapping("/register")
//	public ResponseEntity<User> createUser(@RequestBody UserModel user)
//	{
//		
//		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
//	}
	
	@PostMapping("/register")
	public User createUser(@RequestBody UserModel user)
	{
		UserModel newUser=new UserModel();
		newUser.setAge(user.getAge());
		newUser.setName(user.getName());
		newUser.setEmail(user.getPassword());
		newUser.setPassword(user.getPassword());
		return userService.createUser(user);
	}
	
	
}
