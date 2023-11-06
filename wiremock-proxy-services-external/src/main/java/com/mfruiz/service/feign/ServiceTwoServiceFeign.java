package com.mfruiz.service.feign;

import com.mfruiz.service.model.CustomRequestData;
import com.mfruiz.service.model.CustomResponseData;
import java.util.List;
import java.util.Map;
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
	CustomResponseData postTestData(@RequestBody final CustomRequestData customRequestData);
}