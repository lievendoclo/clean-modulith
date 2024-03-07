package be.sourcedbvba.modulith.customer.internal.app

import be.sourcedbvba.modulith.customer.internal.domain.Customers
import org.jmolecules.architecture.hexagonal.Application
import org.jmolecules.architecture.hexagonal.Port
import org.springframework.stereotype.Component

data class FindCustomersResponseModel(
    val id: String,
    val name: String
)

@Port
interface FindCustomers {
    fun findAll(): List<FindCustomersResponseModel>
}

@Application
@Component
class FindCustomersQuery(
    private val customers: Customers
) : FindCustomers {
    override fun findAll(): List<FindCustomersResponseModel> {
       return customers.findCustomers().map { FindCustomersResponseModel(it.id, it.name) }
    }
}