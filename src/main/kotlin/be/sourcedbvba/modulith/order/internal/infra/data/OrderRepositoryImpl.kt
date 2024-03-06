package be.sourcedbvba.modulith.order.internal.infra.data

import be.sourcedbvba.modulith.order.internal.domain.Order
import be.sourcedbvba.modulith.order.internal.domain.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl: OrderRepository {
    override fun findAll(): List<Order> {
        return listOf(Order("99"))
    }
}