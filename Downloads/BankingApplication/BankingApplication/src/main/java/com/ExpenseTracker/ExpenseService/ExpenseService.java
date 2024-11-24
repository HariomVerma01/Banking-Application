package com.ExpenseTracker.ExpenseService;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ExpenseTracker.entity.Expense;

public interface ExpenseService {
	
	Page<Expense> getAllExpense(Pageable page);

	Optional<Expense> findUserId(Long id);
	
	Boolean createUser(String name,String Description,
			Double getExpense_amount,String category,Date date);
	Boolean deleteUser(Long id);
	Expense createUserObj(Expense expese);
	Expense updateRecord(long id, Expense exp);
	List<Expense> getByCategory(String category,Pageable Page);
	List<Expense> getDataBetweenDate(Date startDate,Date endDate,Pageable Page);
}
