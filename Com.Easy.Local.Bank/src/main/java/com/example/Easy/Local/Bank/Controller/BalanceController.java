package com.example.Easy.Local.Bank.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
	
	@GetMapping("/getBalance")
	public String getBalanceDetails()
	{
		return "Get Balance Details from the DB";
	}

}
