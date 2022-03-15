package com.pauloelienay.customerservice.models

import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FlightTest {
	@Test
	fun code() {
		val flight = Flight()
		flight.from = "DUB"
		flight.to = "LON"

		assertEquals("DUB_LON", flight.code)
	}
	
	@Test
	fun isArrivable() {
		val flight1 = Flight()
		flight1.leavingAt = LocalDateTime.now().plusHours(2)
		val flight2 = Flight()
		flight2.leavingAt = LocalDateTime.now().minusDays(2)

		assertTrue(flight1.isArrivable)
		assertFalse(flight2.isArrivable)
	}
}