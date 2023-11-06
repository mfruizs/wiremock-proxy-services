package com.mfruiz.service.wiremock.business;

import static com.mfruiz.service.wiremock.model.WiremockErrorConstants.ERROR_INCORRECT_STUB_MAP_CONFIGURE_METHOD;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.RequestListener;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import com.mfruiz.service.wiremock.model.WiremockException;
import com.mfruiz.service.wiremock.model.StubMap;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WireMockAggregator {

	private static final int LOWER_PRIORITY = 9999;

	public StubMapping createStubMappings(final StubMap stubMap) {

		if (this.isNotValidStubMap(stubMap)) {
			throw WiremockException.builder()
				.code(ERROR_INCORRECT_STUB_MAP_CONFIGURE_METHOD)
				.message("Missing configuration for proxy stub mapping")
				.httpStatus(HttpStatus.BAD_REQUEST)
				.build();
		}

		return stubMap.getMethod()
			.withName("proxy request - " + stubMap.getName())
			.willReturn(
				WireMock.aResponse().proxiedFrom(stubMap.getForwardServer())
			)
			.atPriority(LOWER_PRIORITY).build();
	}

	public RequestListener createListenerForRequest() {

		return (request, response) -> log.debug("Request received: " + request.getUrl());
	}

	private boolean isNotValidStubMap(final StubMap stubMap) {

		return Objects.isNull(stubMap)
			|| StringUtils.isAnyBlank(stubMap.getName(), stubMap.getUrlPath(), stubMap.getForwardServer());

	}

}
