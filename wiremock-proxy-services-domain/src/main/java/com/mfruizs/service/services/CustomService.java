package com.mfruizs.service.services;

import com.mfruizs.service.feign.ServiceOneServiceFeign;
import com.mfruizs.service.feign.ServiceTwoServiceFeign;
import com.mfruizs.service.model.CustomRequestData;
import com.mfruizs.service.model.CustomResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@RequiredArgsConstructor
public class CustomService {

	private final ServiceOneServiceFeign serviceOneServiceFeign;
	private final ServiceTwoServiceFeign serviceTwoServiceFeign;

	public String recoverResponseFromHttpStatusExternalService(String codeStatus) {

		ResponseStatus response = serviceOneServiceFeign.getInternalServerErrorResponseStatus(codeStatus);
		return response.code().toString();
	}

	public CustomResponseData recoverResponseFromEchoPostmanExternalService(CustomRequestData customRequestData) {

		return serviceTwoServiceFeign.postTestData(customRequestData);
	}


}
