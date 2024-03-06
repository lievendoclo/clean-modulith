package be.sourcedbvba.modulith.customer.internal.infra.data

import be.sourcedbvba.modulith.customer.internal.domain.Customer
import be.sourcedbvba.modulith.customer.internal.domain.CustomerRepository
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryImpl: CustomerRepository {
    override fun findCustomers(): List<Customer> {
        return listOf(
            Customer("1", "Elon Musk")
        )
    }
}