package com.pauloelienay.customerservice.models

import java.time.LocalDate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonDetailsTest {
	@Test
	fun returnsFullName() {
		val person = PersonDetails()

		person.firstName = "John"
		person.lastName = "Doe"

		assertEquals("John Doe", person.fullName)
	}

	@Test
	fun calculatesAge() {
		val person = PersonDetails()

		person.birthDate = LocalDate.of(2000, 7, 30)

		assertEquals(21, person.age)
	}
}