package com.example.Easy.Local.Bank.Events;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthenticationEvent {

	@EventListener
	public void onSuccess(AuthenticationSuccessEvent successEvent)
	{
		log.info("User is logged in {}:",successEvent.getAuthentication().getName());
	}
	
	@EventListener
	public void onFailure(AbstractAuthenticationFailureEvent failureEvent)
	{
		log.info("User logging {} is failed due to {}:",failureEvent.getAuthentication().getName(),
				failureEvent.getException().getMessage());
	}
}
