package com.mfruiz.service.configuration;

import com.mfruiz.service.feign.ServiceOneServiceFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {ServiceOneServiceFeign.class})
public class ServiceOneSpringConfiguration {

}