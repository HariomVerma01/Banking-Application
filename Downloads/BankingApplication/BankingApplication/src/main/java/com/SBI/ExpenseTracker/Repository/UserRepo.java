package com.SBI.ExpenseTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SBI.ExpenseTracker.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
