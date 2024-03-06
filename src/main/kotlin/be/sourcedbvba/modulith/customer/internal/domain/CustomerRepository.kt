package be.sourcedbvba.modulith.customer.internal.domain

import org.jmolecules.architecture.hexagonal.SecondaryPort

@SecondaryPort
interface CustomerRepository {
    fun findCustomers(): List<Customer>
}