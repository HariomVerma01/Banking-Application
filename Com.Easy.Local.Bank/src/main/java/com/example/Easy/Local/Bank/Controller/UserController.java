package com.example.Easy.Local.Bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Easy.Local.Bank.DomainModel.Customer;
import com.example.Easy.Local.Bank.Repository.CustomerRepository;

@RestController
public class UserController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Customer customer)
	{
		try
		{
			if(customer!=null)
			{
				String hashpwd=passwordEncoder.encode(customer.getPwd());
				customer.setPwd(hashpwd);
				Customer cust=customerRepository.save(customer);
			}
			if(customer.getId()>0)
			{
				return ResponseEntity.status(HttpStatus.OK).
						body("User Created Successfully"); 
			}
			else
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).
						body("User is not created");
			}
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
					body("An exception occured"+ ex.getMessage());
		}
	}
}
