package be.sourcedbvba.modulith.order.internal.app.impl

import be.sourcedbvba.modulith.order.internal.app.api.FindOrders
import be.sourcedbvba.modulith.order.internal.app.api.OrderResponseModel
import be.sourcedbvba.modulith.order.internal.domain.OrderRepository
import org.springframework.stereotype.Component

@Component
class FindOrdersImpl(
    private val orderRepository: OrderRepository
): FindOrders {
    override fun find(): List<OrderResponseModel> {
        return orderRepository.findAll().map { OrderResponseModel(it.id) }
    }
}