package com.example.Easy.Local.Bank.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	
	@GetMapping("/getContact")
	public String getContactDetails()
	{
		return "Get Contact Details from the DB";
	}

}
