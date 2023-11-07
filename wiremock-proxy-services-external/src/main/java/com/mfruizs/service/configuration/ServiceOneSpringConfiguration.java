package com.mfruizs.service.configuration;

import com.mfruizs.service.feign.ServiceOneServiceFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {ServiceOneServiceFeign.class})
public class ServiceOneSpringConfiguration {

}