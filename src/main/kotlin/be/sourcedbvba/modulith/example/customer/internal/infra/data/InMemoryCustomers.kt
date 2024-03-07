package be.sourcedbvba.modulith.example.customer.internal.infra.data

import be.sourcedbvba.modulith.example.customer.internal.domain.Customer
import be.sourcedbvba.modulith.example.customer.internal.domain.Customers
import be.sourcedbvba.modulith.example.customer.internal.domain.event.CustomerCreated
import org.jmolecules.architecture.hexagonal.SecondaryAdapter
import org.springframework.context.event.EventListener
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

    @EventListener
    fun handleCustomerCreated(customerCreated: CustomerCreated) {
        customers.put(customerCreated.id, Customer(customerCreated.id, customerCreated.name))
    }
}