package be.sourcedbvba.modulith.customer.internal.infra.data

import be.sourcedbvba.modulith.customer.internal.domain.Customer
import be.sourcedbvba.modulith.customer.internal.domain.Customers
import org.jmolecules.architecture.hexagonal.SecondaryAdapter
import org.springframework.stereotype.Repository

@SecondaryAdapter
@Repository
class InMemoryCustomers: Customers {
    val customers = mutableMapOf(
        Pair("1", Customer("1", "Elon Musk"))
    )

    override fun findCustomers(): List<Customer> {
        return customers.values.toList()
    }

    override fun save(customer: Customer) {
        customers.put(customer.id, customer)
    }
}