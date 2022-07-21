//package com.sks.sa.security;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.jwt.Jwt;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//public class TokenValidator {
//	
//	public static final long JWT_TOKEN_VALIDITY =  60*60;
//
//	private static String secret = "cardinal";
//	
//	
//	private TokenValidator() {
//	}
//
//	public static Authentication validateToken(HttpServletRequest request) {
//		String token = request.getHeader("Authorization");
//		if(token.startsWith("Bearer")) {
//			token = token.split(" ")[1];
//		}
//		return null;
//	}
//	
//	public static String generateToken(UserDetail userDetails) {
//		Map<String, Object> claims = new HashMap<>();
//		return doGenerateToken(claims, userDetails.getUserId().toString());
//	}
//
//	private static String doGenerateToken(Map<String, Object> claims, String subject) {
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//				.signWith(SignatureAlgorithm.HS512, secret).compact();
//	}
//
//
//
//}
