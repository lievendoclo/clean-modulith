package be.sourcedbvba.modulith.customer.internal.infra.web

import be.sourcedbvba.modulith.customer.internal.app.FindCustomers
import org.jmolecules.architecture.hexagonal.Adapter
import org.jmolecules.architecture.hexagonal.PrimaryAdapter
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@PrimaryAdapter
@Controller
class CustomerGraphQL(
    private val findCustomers: FindCustomers
) {
    @QueryMapping("customers")
    fun getCustomers(): List<CustomerJson> {
        return findCustomers.findAll().map { CustomerJson(it.id) }
    }
}