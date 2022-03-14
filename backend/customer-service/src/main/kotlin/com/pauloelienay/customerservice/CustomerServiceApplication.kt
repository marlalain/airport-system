package com.pauloelienay.customerservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
class CustomerServiceApplication

fun main(args: Array<String>) {
	runApplication<CustomerServiceApplication>(*args)
}
