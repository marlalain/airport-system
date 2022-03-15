package com.pauloelienay.customerservice.models

data class Ticket(
	var flight: Flight = Flight(),

	private var bought: Boolean = false,
) {
	val code: String?
		get() = flight.code

	fun buy() {
		bought = true
	}
}
