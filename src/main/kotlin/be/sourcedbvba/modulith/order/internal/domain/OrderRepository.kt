package be.sourcedbvba.modulith.order.internal.domain

interface OrderRepository {
    fun findAll(): List<Order>
}