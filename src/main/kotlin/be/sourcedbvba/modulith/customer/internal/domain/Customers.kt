package be.sourcedbvba.modulith.customer.internal.domain

import org.jmolecules.architecture.hexagonal.SecondaryPort

@SecondaryPort
interface Customers {
    fun findCustomers(): List<Customer>
    fun save(customer: Customer)
}