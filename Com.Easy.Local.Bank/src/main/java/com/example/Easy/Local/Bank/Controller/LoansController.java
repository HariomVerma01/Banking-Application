package com.example.Easy.Local.Bank.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
	
	@GetMapping("/getLoan")
	public String getLoansDetails()
	{
		return "Get Loans Details from the DB";
	}

}
