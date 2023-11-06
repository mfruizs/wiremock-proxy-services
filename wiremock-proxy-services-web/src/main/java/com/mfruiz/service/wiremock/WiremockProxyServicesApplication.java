package com.mfruiz.service.wiremock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableFeignClients(basePackages = "com.mfruiz.service")
public class WiremockProxyServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiremockProxyServicesApplication.class, args);
	}

}
