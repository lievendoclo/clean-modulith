package be.sourcedbvba.modulith.customer.internal.app

import be.sourcedbvba.modulith.customer.internal.domain.Customer
import be.sourcedbvba.modulith.customer.internal.domain.Customers
import org.jmolecules.architecture.hexagonal.Application
import org.jmolecules.architecture.hexagonal.Port
import org.springframework.stereotype.Component

data class CreateCustomerResponseModel(
    val id: String
)

data class CreateCustomerRequestModel(
    val name: String
)

@Port
interface CreateCustomer {
    fun create(request: CreateCustomerRequestModel): CreateCustomerResponseModel
}

@Application
@Component
class CreateCustomerCommand(
    private val customers: Customers
) : CreateCustomer {
    override fun create(request: CreateCustomerRequestModel): CreateCustomerResponseModel {
        val createdCustomer = Customer.createNew(request.name)
        customers.save(createdCustomer)
        return CreateCustomerResponseModel(createdCustomer.id)
    }
}