package com.mfruizs.example.controller;

import com.mfruizs.example.model.CustomRequestData;
import com.mfruizs.example.model.CustomResponseData;
import com.mfruizs.example.services.CustomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Custom controller")
@RestController
@RequestMapping("/api/test")
@RefreshScope
@AllArgsConstructor
public class CustomController {

	private final CustomService customService;

	@GetMapping
	public ResponseEntity<String> recoverResponseFromServiceOne(@RequestParam String codeStatus) {

		String response = customService.recoverResponseFromServiceOne(codeStatus);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CustomResponseData> recoverResponseFromServiceTwo(@RequestBody CustomRequestData customRequestData) {

		CustomResponseData response = customService.recoverResponseFromServiceTwo(customRequestData);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
