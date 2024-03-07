package be.sourcedbvba.modulith.example.order.internal.infra.web

import be.sourcedbvba.modulith.example.order.internal.app.FindOrders
import be.sourcedbvba.modulith.support.graphql.Identifiable
import org.jmolecules.architecture.hexagonal.PrimaryAdapter
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

    @BatchMapping(typeName = "Customer", field = "orders", maxBatchSize = 10)
    fun getOrdersForCustomers(customerIds: List<Identifiable>): Map<Identifiable, List<OrderJson>> {
        return customerIds.associateWith {
            findOrders.find().map { OrderJson(it.id) }
        }
    }
}