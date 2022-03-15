package com.pauloelienay.customerservice.controllers

import com.pauloelienay.customerservice.extensions.logger
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Controller

@Controller
data class CustomerController(val template: KafkaTemplate<String, String>) {
	val log = logger<CustomerController>()

	@KafkaListener(topics = ["customers"])
	fun receive(@Payload message: String, @Headers headers: MessageHeaders) {
		log.info("customers: $message")
		template.send("customers", "Hello!")
	}
}