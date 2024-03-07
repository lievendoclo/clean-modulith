package be.sourcedbvba.modulith.example.order.internal.domain

import org.jmolecules.architecture.hexagonal.SecondaryPort

@SecondaryPort
interface OrderRepository {
    fun findAll(): List<Order>
}