package be.sourcedbvba.modulith.order.internal.infra.web

import be.sourcedbvba.modulith.order.internal.app.FindOrders
import org.jmolecules.architecture.hexagonal.PrimaryAdapter
import org.jmolecules.ddd.types.Identifiable
import org.springframework.graphql.data.method.annotation.BatchMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@PrimaryAdapter
@Controller
class OrderGraphQL(
    private val findOrders: FindOrders
) {
    @QueryMapping("orders")
    fun getOrders(): List<OrderJson> {
        return findOrders.find().map { OrderJson(it.id) }
    }

    @BatchMapping(typeName = "Customer", field = "orders")
    fun getOrdersForCustomers(customerIds: List<Identifiable<String>>): Map<Identifiable<String>, List<OrderJson>> {
        return customerIds.associateWith {
            findOrders.find().map { OrderJson(it.id) }
        }
    }
}