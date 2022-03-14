package com.pauloelienay.gatewayservice.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Gateway {
	@Bean
	fun routes(routeLocatorBuilder: RouteLocatorBuilder): RouteLocator = routeLocatorBuilder
		.routes()
		.build()
}