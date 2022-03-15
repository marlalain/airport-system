package com.pauloelienay.customerservice.models

import java.time.LocalDate

data class PersonDetails(
	var firstName: String? = null,
	var lastName: String? = null,
	var document: String? = null,
	var birthDate: LocalDate? = null,
) {
	val fullName: String?
		get() = if (firstName == null) if (lastName == null) null else lastName else "$firstName $lastName"

	val age: Int?
		get() {
			birthDate?.let {
				val today = LocalDate.now()
				return today.year - it.year - if (it.dayOfYear >= today.dayOfYear) 1 else 0
			}

			return null
		}
}