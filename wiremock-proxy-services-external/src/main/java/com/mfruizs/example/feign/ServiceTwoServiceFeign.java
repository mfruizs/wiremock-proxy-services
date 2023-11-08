package com.mfruizs.example.feign;

import com.mfruizs.example.model.CustomRequestData;
import com.mfruizs.example.model.CustomResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
	name = "${serviceTwo.name}",
	url = "${serviceTwo.url}",
	dismiss404 = true
)
public interface ServiceTwoServiceFeign {

	@PostMapping(path = "${serviceTwo.paths.postCustomData}",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	CustomResponseData getResponse(@RequestBody final CustomRequestData customRequestData);
}