package be.sourcedbvba.modulith.example.customer.internal.infra.web

import be.sourcedbvba.modulith.example.customer.internal.app.CreateCustomer
import be.sourcedbvba.modulith.example.customer.internal.app.CreateCustomerRequestModel
import be.sourcedbvba.modulith.example.customer.internal.app.FindCustomers
import org.jmolecules.architecture.hexagonal.Adapter
import org.jmolecules.architecture.hexagonal.PrimaryAdapter
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@PrimaryAdapter
@Controller
class CustomerGraphQL(
    private val findCustomers: FindCustomers,
    private val createCustomer: CreateCustomer
) {
    @QueryMapping("customers")
    fun getCustomers(): List<CustomerJson> {
        return findCustomers.findAll().map { CustomerJson(it.id, it.name) }
    }

    @MutationMapping("createCustomer")
    fun createCustomer(@Argument name: String): String {
        val response = createCustomer.create(CreateCustomerRequestModel(name))
        return response.id
    }
}