package com.example.ApiGateWay;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfig {
	
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	    return builder.routes()
	      .route("r1", r -> r.path("/payment/**")
	        .uri("lb://PAYMENT-SERVICE"))
	      .route(r -> r.path("/order/**")
	  	        .uri("lb://ORDER-SERVICE"))
	    .build();
	}

}
