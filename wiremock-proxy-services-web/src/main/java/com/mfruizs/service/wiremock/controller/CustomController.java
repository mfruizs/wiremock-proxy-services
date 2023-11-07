package com.mfruizs.service.wiremock.controller;

import com.mfruizs.service.model.CustomRequestData;
import com.mfruizs.service.model.CustomResponseData;
import com.mfruizs.service.services.CustomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity recoverResponseFromHttpStatusExternalService(@RequestParam String codeStatus) {

		String response = customService.recoverResponseFromHttpStatusExternalService(codeStatus);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity recoverResponseFromEchoPostmanExternalService(@RequestParam CustomRequestData customRequestData) {

		CustomResponseData response = customService.recoverResponseFromEchoPostmanExternalService(customRequestData);
		return new ResponseEntity(response, HttpStatus.OK);
	}

}
