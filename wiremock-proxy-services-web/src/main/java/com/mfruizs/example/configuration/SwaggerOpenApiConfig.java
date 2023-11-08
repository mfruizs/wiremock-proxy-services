package com.mfruizs.example.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SwaggerOpenApiConfig {
	@Bean
	public OpenAPI baseOpenAPI(){
		return new OpenAPI().components(new Components())
			.info(new Info()
					  .title("Springboot_Swagger Project OpenAPI Docs")
					  .version("1.0.0").description("Doc Description"));
	}
}
