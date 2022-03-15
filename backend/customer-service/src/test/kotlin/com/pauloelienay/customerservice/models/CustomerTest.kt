package com.pauloelienay.customerservice.models

import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class CustomerTest {
	@Test
	fun canAddTicketToCart() {
		val customer = Customer()
		val ticket1 = Ticket()
		val ticket2 = Ticket()

		customer addToCart ticket1
		customer += ticket2

		assertTrue(ticket1 in customer)
		assertTrue(ticket2 in customer)
	}

	@Test
	fun groupedCart() {
		val customer = Customer()
		val ticket = Ticket()
		ticket.flight.from = "LON"
		ticket.flight.to = "DUB"

		customer addToCart ticket
		customer += ticket

		assertEquals(mapOf("LON_DUB" to listOf(ticket, ticket)), customer.groupedCart)
	}

	@Test
	fun checkoutCart() {
		val customer = Customer()
		val ticket = Ticket()
		ticket.flight.from = "BR"
		ticket.flight.to = "US"
		ticket.flight.leavingAt = LocalDateTime.now().plusHours(2)

		customer addToCart ticket
		customer.checkout()

		println(customer.groupedCart)
	}
}