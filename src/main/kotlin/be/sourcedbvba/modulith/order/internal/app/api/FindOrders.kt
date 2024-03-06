package be.sourcedbvba.modulith.order.internal.app.api

interface FindOrders {
    fun find(): List<OrderResponseModel>
}