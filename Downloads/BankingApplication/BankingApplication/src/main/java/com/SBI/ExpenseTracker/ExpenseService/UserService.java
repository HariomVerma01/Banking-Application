package com.SBI.ExpenseTracker.ExpenseService;

import com.SBI.ExpenseTracker.entity.User;
import com.SBI.ExpenseTracker.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel userModel);
}
