package com.sks.sa.boss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sks.sa.boss.dm.bean.User;
import com.sks.sa.boss.mapper.JwtRequest;
import com.sks.sa.boss.mapper.JwtResponse;
import com.sks.sa.boss.service.UserService;
import com.sks.sa.security.UserDetail;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
@Tag(name = "dashboard-controller")
public class DashboardController {
	
	@Autowired
	private UserService userService;
	
	
	@Operation(summary = "login token generator " , responses = {
			@ApiResponse(responseCode = "200" , description = "Success"),
			@ApiResponse(responseCode = "500" , description = "failed" , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	})
	@PostMapping(value = "/login"
	,	consumes = MediaType.APPLICATION_JSON_VALUE )
	
	public ResponseEntity<String> createAuthenticationToken(@RequestBody JwtRequest jwtRequest)
			throws Exception {
		JwtResponse response = new JwtResponse();
		String token = null;
		if (jwtRequest.getUserId() != null && jwtRequest.getPassword() != null) {
			Boolean userRights = userService.findUser(jwtRequest.getUserId(),
					jwtRequest.getPassword());
			if (userRights) {
				User userdetails = userService.getUser(jwtRequest.getUserId());
				ObjectMapper mapper = new ObjectMapper();
				token = "access-token";
				response.setJwtToken(token);
			} else {
				token = "false-token";
				response.setJwtToken(token);
			}
		}
		return new ResponseEntity<>(token,HttpStatus.OK);
	}
}
//	
//	@Autowired
//	private AppService appService;
//	
//	
//	@RequestMapping(value = "/user-details" , method = RequestMethod.GET)
//	public List<UserBean> getAllUser(){
//		List<UserBean> listData = appService.getAllrecord();
//		if(listData.size() == 0) {
//			throw new AppException("User List is empty");
//		}
//		return listData;
//	}
//	
//	@RequestMapping(value = "/emp-details" , method = RequestMethod.GET)
//	public List<EmployeeBean> getAllEmployee(){
//		List<EmployeeBean> listData = appService.getAllEmployee();
//		return listData;
//	}
//	
//	@RequestMapping(value = "/new-user" , method = RequestMethod.POST)
//	public Integer addUser(@RequestBody NewUser user) {
//		return appService.addNewUser(user);
//	}
//	
//	
//////	@SuppressWarnings("unchecked")
////	@Operation(description = "Send mail for get password" , responses = {
////			@ApiResponse(responseCode = "200" , description = "successfully mail sent"),
////			@ApiResponse(responseCode = "500" , description = "try again")})
////	@RequestMapping(value = "/sendmail/{mailTo}" , method = RequestMethod.GET)
////	public String sendMailTo(@PathVariable("mailTo") String mailTo ) {
////		return  mailConfig.sendMailMethod(mailTo, "Hi ...this one dummy", "we are good with the code");
////	}
//	
//	@GetMapping(value = "/getOtp/{phoneNumber}")
//	public String sendSmsOperation(@PathVariable("phoneNumber") String phoneNumber) {
//		return appService.sendsms(phoneNumber);
//	}
//
//}
