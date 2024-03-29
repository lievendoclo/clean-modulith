package be.sourcedbvba.modulith.example.order.internal.infra.data

import be.sourcedbvba.modulith.example.order.internal.domain.Order
import be.sourcedbvba.modulith.example.order.internal.domain.OrderRepository
import org.jmolecules.architecture.hexagonal.SecondaryAdapter
import org.springframework.stereotype.Repository

@SecondaryAdapter
@Repository
class OrderRepositoryImpl: OrderRepository {
    override fun findAll(): List<Order> {
        return listOf(Order("99"))
    }
}