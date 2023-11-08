package com.mfruizs.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CustomResponseData {

	@Schema(type = "int", example = "101")
	private Integer id;

	@Schema(type = "String", example = "foo")
	private String title;

	@Schema(type = "String", example = "bar")
	private String body;

	@Schema(type = "int", example = "1")
	private Integer userId;
}
