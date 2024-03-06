package be.sourcedbvba.modulith.order.internal.app

import be.sourcedbvba.modulith.order.internal.domain.OrderRepository
import org.springframework.stereotype.Component

data class OrderResponseModel(
    val id: String
)

@Component
class FindOrders(
    private val orderRepository: OrderRepository
) {
    fun find(): List<OrderResponseModel> {
        return orderRepository.findAll().map { OrderResponseModel(it.id) }
    }
}