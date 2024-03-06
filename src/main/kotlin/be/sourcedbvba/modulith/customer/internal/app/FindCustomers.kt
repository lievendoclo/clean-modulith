package be.sourcedbvba.modulith.customer.internal.app

import be.sourcedbvba.modulith.customer.internal.domain.CustomerRepository
import org.jmolecules.architecture.hexagonal.Application
import org.jmolecules.architecture.hexagonal.PrimaryPort
import org.springframework.stereotype.Component

data class FindCustomersResponseModel(
    val id: String,
    val name: String
)

@PrimaryPort
interface FindCustomers {
    fun findAll(): List<FindCustomersResponseModel>
}

@Application
@Component
class DefaultFindCustomers(
    private val customerRepository: CustomerRepository
) : FindCustomers {
    override fun findAll(): List<FindCustomersResponseModel> {
       return customerRepository.findCustomers().map { FindCustomersResponseModel(it.id, it.name) }
    }
}