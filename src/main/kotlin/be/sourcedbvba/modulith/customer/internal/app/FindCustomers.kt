package be.sourcedbvba.modulith.customer.internal.app

import be.sourcedbvba.modulith.customer.internal.domain.CustomerRepository
import org.springframework.stereotype.Component

data class FindCustomersResponseModel(
    val id: String,
    val name: String
)

@Component
class FindCustomers(
    private val customerRepository: CustomerRepository
) {
    fun findAll(): List<FindCustomersResponseModel> {
       return customerRepository.findCustomers().map { FindCustomersResponseModel(it.id, it.name) }
    }
}