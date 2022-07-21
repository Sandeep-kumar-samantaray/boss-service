package com.sks.sa.boss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sks.sa.boss.framework.db.PrepareInitialData;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin
@Tag(name = "read-from-json-file")
public class ReadDataFromJson {
	
	@Autowired
	private PrepareInitialData initialData;
	
	@Operation(summary = "read json file Call " )
	@ApiResponses(value = {
			@ApiResponse(description = "Success ", responseCode = "200"),
			@ApiResponse(description = "Failed ", responseCode = "500")})
	@PostMapping(value = "/test-json" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE , 
	produces = MediaType.ALL_VALUE
			)
	public ResponseEntity<String> writeToDbFromJSON(@RequestPart("file") MultipartFile file) {
		initialData.insertMockData();
		return new ResponseEntity<>("success",HttpStatus.OK);
	}

}
