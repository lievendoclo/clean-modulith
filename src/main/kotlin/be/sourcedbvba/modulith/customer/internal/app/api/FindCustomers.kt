package be.sourcedbvba.modulith.customer.internal.app.api

data class FindCustomersResponseModel(
    val id: String
)

interface FindCustomers {
    fun findAll(): List<FindCustomersResponseModel>
}