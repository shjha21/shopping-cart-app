package com.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionTimeoutFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		HttpSession session=request.getSession(false);
		
		boolean isLoggedIn=(session!=null && session.getAttribute("username")!=null);
		boolean isLoginRequest=request.getRequestURI().contains("/login");
		
		if(!isLoggedIn && !isLoginRequest) {
			response.sendRedirect("/user/login");
			return;
		}
		
		chain.doFilter(request, response);
		
	}

}
