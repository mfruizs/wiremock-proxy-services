package com.mfruizs.service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomRequestData {

	@Schema(type = "String", example = "1")
	private String id;
	@Schema(type = "String", example = "test")
	private String name;
}
