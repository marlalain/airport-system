package com.pauloelienay.customerservice.models

data class Customer(
	var details: PersonDetails? = null,
	private val cart: MutableCollection<Ticket> = mutableListOf()
) {
	val groupedCart: Map<String?, List<Ticket>> get() = cart.groupBy { it.code }

	infix fun addToCart(ticket: Ticket) {
		cart.add(ticket)
	}

	operator fun plusAssign(ticket: Ticket) {
		addToCart(ticket)
	}

	operator fun contains(ticket: Ticket): Boolean = ticket in cart
}
