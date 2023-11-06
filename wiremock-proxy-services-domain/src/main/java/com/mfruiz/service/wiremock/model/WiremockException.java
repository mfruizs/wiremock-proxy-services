package com.mfruiz.service.wiremock.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder(toBuilder = true)
public class WiremockException extends RuntimeException{

	private final String code;
	private final HttpStatus httpStatus;
	private final String message;

}
