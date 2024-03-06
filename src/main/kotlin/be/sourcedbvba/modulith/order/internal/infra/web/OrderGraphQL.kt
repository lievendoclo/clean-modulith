package be.sourcedbvba.modulith.order.internal.infra.web

import be.sourcedbvba.modulith.order.internal.app.FindOrders
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class OrderGraphQL(
    private val findOrders: FindOrders
) {
    @QueryMapping("orders")
    fun getOrders(): List<OrderJson> {
        return findOrders.find().map { OrderJson(it.id) }
    }
}