package be.sourcedbvba.modulith.order.internal.domain

import org.jmolecules.architecture.hexagonal.Port

@Port
interface OrderRepository {
    fun findAll(): List<Order>
}