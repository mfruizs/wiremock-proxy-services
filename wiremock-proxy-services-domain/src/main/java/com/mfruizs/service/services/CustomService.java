package com.mfruizs.service.services;

import com.mfruizs.service.feign.ServiceOneServiceFeign;
import com.mfruizs.service.feign.ServiceTwoServiceFeign;
import com.mfruizs.service.model.CustomRequestData;
import com.mfruizs.service.model.CustomResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomService {

	private final ServiceOneServiceFeign serviceOneServiceFeign;
	private final ServiceTwoServiceFeign serviceTwoServiceFeign;

	public String recoverResponseFromServiceOne(String codeStatus) {

		ResponseEntity<String> response = serviceOneServiceFeign.getResponse(codeStatus);
		HttpStatusCode status = response.getStatusCode();
		return status.toString();
	}

	public CustomResponseData recoverResponseFromServiceTwo(CustomRequestData customRequestData) {

		return serviceTwoServiceFeign.getResponse(customRequestData);
	}


}
