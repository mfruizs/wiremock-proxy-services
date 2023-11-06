package com.mfruiz.service.wiremock.model;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "wiremock")
public class WiremockProperties {

	private String host;
	private int port;
	private String httpsPort;
	private String feignUrl;
	private List<StubMap> stubMaps;

}
