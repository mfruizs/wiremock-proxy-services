package com.mfruiz.service.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.mfruiz.service.wiremock.business.WireMockAggregator;
import com.mfruiz.service.wiremock.model.WiremockProperties;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
@ConditionalOnProperty(name = "wiremock.enabled", havingValue = "true")
public class WireMockInitializer {

	private final WireMockServer wireMockServer;
	private final WiremockProperties wireMockConfig;
	private final WireMockAggregator wireMockAggregator;

	@PostConstruct
	public void startWireMockServer() {

		log.debug("Initializing wiremock");
		this.wireMockServer.start();
		this.addExternalProxyFromMapping();
		this.wireMockServer.addMockServiceRequestListener(this.wireMockAggregator.createListenerForRequest());
	}

	private void addExternalProxyFromMapping() {

		this.wireMockConfig.getStubMaps().stream()
			.map(this.wireMockAggregator::createStubMappings).
			forEach(this.wireMockServer::addStubMapping);
	}

}
