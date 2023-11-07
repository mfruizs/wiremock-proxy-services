package com.mfruizs.service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomResponseData {

	@Schema(type = "String", example = "response with some mock information")
	private String responseBody;

}
