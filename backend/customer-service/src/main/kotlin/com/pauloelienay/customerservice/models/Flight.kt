package com.pauloelienay.customerservice.models

import java.time.LocalDateTime

data class Flight(
	var from: String? = null,
	var to: String? = null,
	var registeredAt: LocalDateTime = LocalDateTime.now(),
	var leavingAt: LocalDateTime? = null,
) {
	val code: String?
		get() = if (from == null && to == null) null else "${from!!.capitalize()}_${to!!.capitalize()}"

	val isArrivable: Boolean
		get() {
			if (leavingAt == null) throw IllegalAccessError("Not enough information to perform this action.")

			return LocalDateTime.now().isBefore(leavingAt)
		}
}