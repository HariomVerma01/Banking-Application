package com.ExpenseTracker.ExpenseService;

import com.ExpenseTracker.entity.User;
import com.ExpenseTracker.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel userModel);
}
