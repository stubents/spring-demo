package com.example.demo.repository

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class DemoUser(
        @Id
        val userId: String = UUID.randomUUID().toString(),
        val firstName: String,
        val lastName: String,
        val street: String,
        val houseNo: String? = null,
        val zipCode: String,
        var city: String? = null,
        var state: String? = null,
        var birthday: LocalDate? = null
)