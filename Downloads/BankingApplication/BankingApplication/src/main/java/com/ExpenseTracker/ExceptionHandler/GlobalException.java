package com.ExpenseTracker.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ExpenseTracker.entity.ErrorObject;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ExpenseNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ExpenseNotFoundException ex,WebRequest request)
	{
		ErrorObject obj=new ErrorObject();
		obj.setErrorCode(HttpStatus.NOT_FOUND.value());
		obj.setMessage(ex.getMessage());
		obj.setTimestamp(new Date());
		return new ResponseEntity<ErrorObject>(obj,HttpStatus.NOT_FOUND);
	}
}
