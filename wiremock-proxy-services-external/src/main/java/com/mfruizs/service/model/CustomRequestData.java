package com.mfruizs.service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomRequestData {

	@Schema(type = "String", example = "foo")
	private String title;

	@Schema(type = "String", example = "bar")
	private String body;

	@Schema(type = "int", example = "1")
	private Integer userId;
}
