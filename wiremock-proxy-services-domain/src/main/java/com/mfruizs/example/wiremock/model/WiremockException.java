package com.mfruizs.example.wiremock.model;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder(toBuilder = true)
public class WiremockException extends RuntimeException {

	private final String code;
	private final HttpStatus httpStatus;
	private final String message;

}
