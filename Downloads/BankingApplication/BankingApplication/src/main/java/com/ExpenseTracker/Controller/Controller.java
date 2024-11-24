package com.ExpenseTracker.Controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseTracker.ExceptionHandler.ExpenseNotFoundException;
import com.ExpenseTracker.ExpenseService.ExpenseService;
import com.ExpenseTracker.entity.Expense;

@RestController
public class Controller {

	@Autowired
	private ExpenseService expenseService;

		 @GetMapping("/expenses")
		 public List<Expense> getExpenses(Pageable page) 
		 {
		     return expenseService.getAllExpense(page).toList();
		 }	
		 
		 @GetMapping("/findById/{id}")
		 public String getFindById(@PathVariable Long id)
		 {
			 return "The id is "+id;
		 }
		 
		 @GetMapping("/expensesId")
		 public String deleteById(@RequestParam Long id)
		 {
			 return "The Deleted id is "+id;
		 }
		 
		 @GetMapping("expenseById")
		 public Optional<Expense> getUserById(@RequestParam ("id") Long id) throws Exception
		 {
			 Optional<Expense> obj=expenseService.findUserId(id);
			 if(obj.isPresent())
			 {
				return obj; 
			 }
				 throw new ExpenseNotFoundException("User id not found "+id);
		 }
		 
		 @GetMapping("createUser")
		 public String createUser(@RequestParam String name,@RequestParam String Description,
				 @RequestParam Double getExpense_amount,@RequestParam String category,@RequestParam Date date)
		 {
			Boolean flag= expenseService.createUser(name, Description, getExpense_amount, category, date);
			if(flag=true)
			{
				return "Details Saved";
			}
			else
				return "Details Not Saved";
		 }
		 
		 @GetMapping("/deleteUser")
		 public boolean deleteUser(@RequestParam Long id)
		 {
			 if(expenseService.deleteUser(id))
			 {
				 System.out.println("User is Deleted");
				 return true;
			 }
			 else
			 {
				 System.out.println("User is Not Found");
				 return false;
			 } 
				 
		 }
		 @ResponseStatus(value=HttpStatus.ACCEPTED)
		 @PostMapping("/createUserObj")
		 public boolean createUserObj(@RequestBody Expense exp)
		 {
			 boolean flag=false;
			 Expense x=expenseService.createUserObj(exp);
			 if(x!=null)
			 {
				 flag=true;
			 }
			 return flag;
		 }
		 @PutMapping("/updateRecor/{id}")
		 public Expense updateRecord(@RequestBody Expense exp, @PathVariable Long id)
		 {
			 return expenseService.updateRecord(id, exp);
		 }
		 
		 @PostMapping("/getByCategory/category/{category}")
		 public List<Expense> viewByCategory(@PathVariable String category,Pageable page)
		 {
			 return expenseService.getByCategory(category, page);
		 }
		 
		 @GetMapping("/filterByDate/Date")
		 public List<Expense> getBetweenDate(@RequestParam(required = false) Date startDate,@RequestParam(required = false) Date endDate,Pageable page){
			 return expenseService.getDataBetweenDate(startDate, endDate, page);
		 }
		 
}
