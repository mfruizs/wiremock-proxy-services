package com.mfruizs.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
	name = "${serviceOne.name}",
	url = "${serviceOne.url}",
	dismiss404 = true
)
public interface ServiceOneServiceFeign {

	@GetMapping(path = "/{statusCode}",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> getResponse(@PathVariable(value = "statusCode") final String statusCode);

}