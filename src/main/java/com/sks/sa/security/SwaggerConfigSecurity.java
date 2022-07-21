//package com.sks.sa.security;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@EnableWebSecurity
//public class SwaggerConfigSecurity extends WebSecurityConfigurerAdapter {
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
//				"/configuration/security", "/swagger-ui.html", "/webjars/**", "/h2-console/**", "/h2/**");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/api/**").permitAll().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////	    	http.httpBasic().disable();
////	    	http.cors().and().csrf().disable();
//	}
//
//	protected void registerAuthentication(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//		authManagerBuilder.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN");
//	}
//
//	@Bean
//	public CorsFilter corsFilter() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		final CorsConfiguration config = new CorsConfiguration();
//		config.setAllowedHeaders(Arrays.asList("/*"));
//		config.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "OPTIONS", "DELETE"));
//		config.setAllowedOrigins(Arrays.asList("/*"));
//		config.setAllowCredentials(true);
////		config.addAllowedHeader(null)
//		source.registerCorsConfiguration("/**", config);
//		return new CorsFilter(source);
//
//	}
//
//}
