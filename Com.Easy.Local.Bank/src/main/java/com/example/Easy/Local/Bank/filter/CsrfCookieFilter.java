package com.example.Easy.Local.Bank.filter;

import java.io.IOException;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CsrfCookieFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
//			The CSRF token is not generated immediately—it’s "deferred" (created only when needed).
//			Cause it to be loaded:
//			You need to access the token explicitly to force it to be generated.
//			Render to a cookie:
//			Once it's generated, you can put it into a cookie, so the browser (or frontend code) can access it.
		CsrfToken csrfToken= (CsrfToken)request.getAttribute(CsrfToken.class.getName());
		csrfToken.getToken();
		filterChain.doFilter(request, response);
	}

}
