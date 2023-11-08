package com.mfruizs.example.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.standalone.JsonFileMappingsSource;
import com.mfruizs.example.wiremock.model.WiremockProperties;
import java.nio.file.Path;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@AllArgsConstructor
@ConditionalOnProperty(name = "wiremock.enabled", havingValue = "true")
public class WireMockConfig {

	private static final String JSON_MOCK_PATH = "/wiremock-proxy-services-domain/src/main/resources";
	private final WiremockProperties wiremockProperties;

	@Bean(initMethod = "start", destroyMethod = "stop")
	public WireMockServer wireMockServer() {

		log.debug("Loading wiremock configurations");
		final WireMockConfiguration wireMockConfiguration =
			WireMockConfiguration.options()
				.withRootDirectory(obtainPathForJsonMocks())
				.port(this.wiremockProperties.getPort());

		final WireMockServer wireServer = new WireMockServer(wireMockConfiguration);
		wireServer.loadMappingsUsing(new JsonFileMappingsSource(new ClasspathFileSource("mappings"), null));

		return wireServer;
	}

	private String obtainPathForJsonMocks() {

		return Path.of("").toAbsolutePath() + JSON_MOCK_PATH;
	}

}
