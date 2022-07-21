package com.sks.sa.boss.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.mail.internet.ContentDisposition;
import javax.xml.ws.spi.http.HttpHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sks.sa.boss.dm.bean.User;
import com.sks.sa.boss.dm.mapper.UserVO;
import com.sks.sa.boss.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
@Tag(name = "user-controller")
public class NewUserController {

	@Autowired
	private UserService userService;
	
	@Operation(summary = "Welcome Call " )
	@ApiResponses(value = {
			@ApiResponse(description = "Success ", responseCode = "200"),
			@ApiResponse(description = "Failed ", responseCode = "500")})
	@GetMapping(value = "/welcome/{name}")
	public ResponseEntity<String> welcomeCall(@PathVariable("name") String name) {
		return new ResponseEntity<>("Welcome to Boss Service "+name , HttpStatus.OK);
	}
	
	@Operation(summary = "Upload folder Call " )
	@ApiResponses(value = {
			@ApiResponse(description = "Success ", responseCode = "200"),
			@ApiResponse(description = "Failed ", responseCode = "500")})
	@PostMapping(value = "/upload/{userid}"
	,consumes = MediaType.MULTIPART_FORM_DATA_VALUE
			)
	public ResponseEntity<String> uploadFile(@PathVariable("userid") Long userid ,@RequestPart("file") MultipartFile file){
		String fileName = "test.txt";
		try {
			User user = userService.getUser(userid);
			user.setImage(file.getBytes());
			userService.updateUser(user);
			fileName = user.getFirstName().concat(".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(fileName,HttpStatus.CREATED);
	}
	@Operation(summary = "Download folder Call " )
	@ApiResponses(value = {
			@ApiResponse(description = "Success ", responseCode = "200"),
			@ApiResponse(description = "Failed ", responseCode = "500")})
	@PostMapping(value = "/download/{userid}"
	,produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
			)
	public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable("userid") Long userid) throws IOException {
		File fileName = null;
		byte[] imagevalue = null;
		User user = userService.getUser(userid);
		imagevalue = user.getImage();
		InputStream is = new ByteArrayInputStream(imagevalue);
		BufferedImage image = ImageIO.read(is);
		fileName = new File(user.getFirstName().concat(".png"));
		ImageIO.write(image, "png", fileName);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + fileName + "\"")
				.body(new ByteArrayResource(imagevalue));
	}
	
	@Operation(summary = "Add new user " , responses = {
			@ApiResponse(responseCode = "200" , description = "Success"),
			@ApiResponse(responseCode = "500" , description = "failed" , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	})
	@PostMapping(path  = "/adduser" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVO> createTable(@RequestBody UserVO user){
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@Operation(summary = "Get user by userID" ,responses = {
			@ApiResponse(responseCode = "200" , description = "succee"),
			@ApiResponse(responseCode = "500" , description = "failed")
	})
	@GetMapping(path = "/user/{userId}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUserById(@PathVariable("userId") Long userId){
		User user = userService.getUser(userId);
		user.setImage(null);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	

}
