package be.sourcedbvba.modulith.order.internal.domain

import org.jmolecules.architecture.hexagonal.SecondaryPort

@SecondaryPort
interface OrderRepository {
    fun findAll(): List<Order>
}