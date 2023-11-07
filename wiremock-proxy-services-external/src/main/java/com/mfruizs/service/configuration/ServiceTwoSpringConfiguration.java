package com.mfruizs.service.configuration;

import com.mfruizs.service.feign.ServiceTwoServiceFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {ServiceTwoServiceFeign.class})
public class ServiceTwoSpringConfiguration {

}