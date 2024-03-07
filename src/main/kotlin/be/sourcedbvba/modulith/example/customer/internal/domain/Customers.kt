package be.sourcedbvba.modulith.example.customer.internal.domain

import org.jmolecules.architecture.hexagonal.SecondaryPort

@SecondaryPort
interface Customers {
    fun findCustomers(): List<Customer>
}