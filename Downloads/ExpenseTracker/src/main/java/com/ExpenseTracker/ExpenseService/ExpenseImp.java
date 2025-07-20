package com.ExpenseTracker.ExpenseService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ExpenseTracker.Repository.ExpenseRepo;
import com.ExpenseTracker.entity.Expense;

@Service
public class ExpenseImp implements ExpenseService {
	
	@Autowired
	private ExpenseRepo expenseRepo;
	

	@Override
	public Optional<Expense> findUserId(Long id) {
		Optional<Expense> exp=null;
		exp=expenseRepo.findById(id);
		return exp;
	}

	@Override
	public Boolean createUser(String name,String Description,
			Double getExpense_amount,String category,Date date)
	{
		Expense obj=new Expense();
		obj.setName(name);
		obj.setCategory(category);
		obj.setDescription(Description);
		obj.setAmount(getExpense_amount);
		Expense sve=expenseRepo.save(obj);
		Boolean flag;
		if(sve!=null)
			flag=true;
		else
			flag=false;
		return flag;
	}

	
	@Override
	@Transactional
	public Boolean deleteUser(Long id)
	{
		Boolean flag=false;
		if(expenseRepo.existsById(id))
		{		
		try {
			expenseRepo.deleteById(id);
				flag= true;
			}
			catch(EmptyResultDataAccessException e)
			{
				System.out.print("No Expense is Found with id "+"id");
				flag= false;
			}
		return flag;
		}
		else
		return flag;
	}

	@Override
	public Expense createUserObj(Expense expese) {
		return expenseRepo.save(expese);
	}

	@Override
	public Expense updateRecord(long id, Expense exp) {
		Expense obj=expenseRepo.getById(id);
		obj.setName(exp.getName()!=null ? exp.getName():obj.getName());
		obj.setDescription(exp.getDescription()!=null ? exp.getDescription():obj.getDescription());
		obj.setCategory(exp.getCategory()!=null ? exp.getCategory():obj.getCategory());
		obj.setAmount(exp.getAmount()!=null ? exp.getAmount():obj.getAmount());
		return expenseRepo.save(obj);
	}

	@Override
	public Page<Expense> getAllExpense(Pageable page) {
		return expenseRepo.findAll(page);
	}

	@Override
	public List<Expense> getByCategory(String category, Pageable Page) {
				return expenseRepo.findByCategoryContaining(category, Page).toList();
		}

	@Override
	public List<Expense> getDataBetweenDate(Date startDate, Date endDate, Pageable Page) {
		if(startDate==null)
		{
			startDate=new Date(0);
		}
		if(endDate==null)
		{
			endDate=new Date(System.currentTimeMillis());
		}
		return expenseRepo.findByDateBetween(startDate, endDate, Page).toList();
	}

	
	
	



	
}
