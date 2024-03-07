package be.sourcedbvba.modulith.example.customer.internal.app

import be.sourcedbvba.modulith.example.customer.internal.domain.Customer
import be.sourcedbvba.modulith.example.customer.internal.domain.Customers
import be.sourcedbvba.modulith.example.customer.internal.domain.event.CustomerCreated
import be.sourcedbvba.modulith.support.domain.event.EventPublisher
import org.jmolecules.architecture.hexagonal.Application
import org.jmolecules.architecture.hexagonal.Port
import org.springframework.stereotype.Component
import java.util.*

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
    private val eventPublisher: EventPublisher
) : CreateCustomer {
    override fun create(request: CreateCustomerRequestModel): CreateCustomerResponseModel {
        val createdCustomer = Customer.createNew(request.name)
        eventPublisher.publishEvents(UUID.randomUUID(), listOf(CustomerCreated(createdCustomer.id, createdCustomer.name)))
        return CreateCustomerResponseModel(createdCustomer.id)
    }
}