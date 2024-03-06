package be.sourcedbvba.modulith.customer.internal.app.impl

import be.sourcedbvba.modulith.customer.internal.app.api.FindCustomersResponseModel
import be.sourcedbvba.modulith.customer.internal.app.api.FindCustomers
import be.sourcedbvba.modulith.customer.internal.domain.CustomerRepository
import org.springframework.stereotype.Component

@Component
class FindCustomersImpl(
    private val customerRepository: CustomerRepository
): FindCustomers {
    override fun findAll(): List<FindCustomersResponseModel> {
       return customerRepository.findCustomers().map { FindCustomersResponseModel(it.id) }
    }
}