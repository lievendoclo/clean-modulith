package be.sourcedbvba.modulith.order.internal.app

import be.sourcedbvba.modulith.order.internal.domain.OrderRepository
import org.jmolecules.architecture.hexagonal.Application
import org.jmolecules.architecture.hexagonal.PrimaryPort
import org.springframework.stereotype.Component

data class OrderResponseModel(
    val id: String
)

@PrimaryPort
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