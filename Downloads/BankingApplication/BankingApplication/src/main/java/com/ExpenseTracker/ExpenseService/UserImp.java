package com.ExpenseTracker.ExpenseService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseTracker.Repository.UserRepo;
import com.ExpenseTracker.entity.User;
import com.ExpenseTracker.entity.UserModel;

@Service
public class UserImp implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User createUser(UserModel userModel) {
		User newUser=new User();
		BeanUtils.copyProperties(userModel, newUser);
		return userRepo.save(newUser);
	}

}
