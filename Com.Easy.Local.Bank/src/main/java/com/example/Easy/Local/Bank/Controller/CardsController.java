package com.example.Easy.Local.Bank.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
	
	@GetMapping("/getCards")
	public String getCardsDetails()
	{
		return "Get Cards Details from the DB";
	}

}
