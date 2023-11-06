package com.mfruiz.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
	name = "${serviceOne.name}",
	url = "${serviceOne.url}",
	dismiss404 = true
)
public interface ServiceOneServiceFeign {

	@GetMapping(path = "${core.paths.getInternalServerError}",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	void getInternalServerErrorResponseStatus(@RequestParam(value = "statusCode") final String statusCode);

}