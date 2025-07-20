package com.example.Easy.Local.Bank.Config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Easy.Local.Bank.DomainModel.Customer;
import com.example.Easy.Local.Bank.Repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class easyBankServiceDtails implements UserDetailsService{
	
	private final CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer=customerRepository.findByEmail(username).
		orElseThrow(()-> new UsernameNotFoundException("User is not Found"));
		List<GrantedAuthority> authorities=List.of(new SimpleGrantedAuthority(customer.getRole()));
		return new User(customer.getEmail(),customer.getPwd(),authorities);
	}

}
