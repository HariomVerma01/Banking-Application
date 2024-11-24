package com.ExpenseTracker.Repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExpenseTracker.entity.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {
	// Select * from expense where category=%like%
	Page<Expense>findByCategoryContaining(String category,Pageable page);
	
	
	// SELECT * FROM expenses WHERE date BETWEEN :startDate AND :endDate
	Page<Expense> findByDateBetween(Date startDate,Date endDate,Pageable page);
	
}
