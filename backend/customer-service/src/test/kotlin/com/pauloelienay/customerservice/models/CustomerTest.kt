package com.pauloelienay.customerservice.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class CustomerTest {
	@Test
	fun canAddTicketToCart() {
		val customer = Customer()
		val ticket1 = Ticket()
		ticket1.code = "LON_DUB"
		val ticket2 = Ticket()
		ticket2.code = "DUB_LON"

		customer addToCart ticket1
		customer += ticket2

		assertTrue(ticket1 in customer)
		assertTrue(ticket2 in customer)
	}

	@Test
	fun groupedCart() {
		val customer = Customer()
		val ticket = Ticket()
		ticket.code = "LON_DUB"

		customer addToCart ticket
		customer += ticket

		assertEquals(mapOf("LON_DUB" to listOf(ticket, ticket)), customer.groupedCart)
	}
}