package be.sourcedbvba.modulith.example.customer.internal.domain

import java.util.*

class Customer(
    val id: String,
    val name: String
) {
    companion object {
        fun createNew(name: String): Customer {
            return Customer(UUID.randomUUID().toString(), name)
        }
    }
}