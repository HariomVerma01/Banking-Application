package com.example.Easy.Local.Bank.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
	
	@GetMapping("/getNotices")
	public String getNoticeDetails()
	{
	return "Get Notices Details from the DB";
	}

}
