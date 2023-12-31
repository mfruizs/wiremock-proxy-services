package com.mfruizs.example.wiremock.model;

import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.patch;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.mfruizs.example.wiremock.model.WiremockErrorConstants.ERROR_INCORRECT_STUB_MAP_CONFIGURE_METHOD;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import feign.Request.HttpMethod;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class StubMap {

	private String name;
	private String urlPath;
	private String forwardServer;
	private HttpMethod method;

	public MappingBuilder getMethod() {

		if (this.isNotValidStubMap()) {
			throw createWiremockException("Missing mandatory fields <method> or <urlPath>");
		}

		return switch (this.method) {
			case GET -> get(urlPathMatching(this.urlPath));
			case POST -> post(urlPathMatching(this.urlPath));
			case PUT -> put(urlPathMatching(this.urlPath));
			case DELETE -> delete(urlPathMatching(this.urlPath));
			case PATCH -> patch(urlPathMatching(this.urlPath));
			default -> throw createWiremockException("Unexpected value: " + this.method);
		};

	}

	private boolean isNotValidStubMap() {

		return isNull(this.method) || isBlank(this.urlPath);
	}

	public WiremockException createWiremockException(final String errorMsg) {

		return WiremockException.builder()
			.code(ERROR_INCORRECT_STUB_MAP_CONFIGURE_METHOD)
			.message(errorMsg)
			.httpStatus(HttpStatus.BAD_REQUEST)
			.build();
	}
}
