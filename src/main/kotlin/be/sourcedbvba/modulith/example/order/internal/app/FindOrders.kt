package be.sourcedbvba.modulith.example.order.internal.app

import be.sourcedbvba.modulith.example.order.internal.domain.OrderRepository
import org.jmolecules.architecture.hexagonal.Application
import org.jmolecules.architecture.hexagonal.Port
import org.springframework.stereotype.Component

data class OrderResponseModel(
    val id: String
)

@Port
interface FindOrders {
    fun find(): List<OrderResponseModel>
}

@Application
@Component
class DefaultFindOrders(
    private val orderRepository: OrderRepository
) : FindOrders {
    override fun find(): List<OrderResponseModel> {
        return orderRepository.findAll().map { OrderResponseModel(it.id) }
    }
}