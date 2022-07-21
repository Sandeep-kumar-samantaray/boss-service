//package com.sks.sa.security;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.GenericFilterBean;
//
//public class AppAuthenticationFilter extends GenericFilterBean{
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//	{
//		try {
//			Authentication authen = TokenValidator.validateToken((HttpServletRequest) request);
//			SecurityContextHolder.getContext().setAuthentication(authen);
//			chain.doFilter(request, response);
//		} catch (IOException | ServletException e) {
//			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//			e.printStackTrace();
//		}
//	}
//
//}
