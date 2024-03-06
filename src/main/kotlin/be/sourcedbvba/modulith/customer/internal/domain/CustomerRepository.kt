package be.sourcedbvba.modulith.customer.internal.domain

import org.jmolecules.architecture.hexagonal.Port
import org.jmolecules.architecture.hexagonal.SecondaryPort

@Port
interface CustomerRepository {
    fun findCustomers(): List<Customer>
}