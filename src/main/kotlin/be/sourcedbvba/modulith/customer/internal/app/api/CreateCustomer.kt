package be.sourcedbvba.modulith.customer.internal.app.api

data class CreateCustomerRequestModel(
    val name: String
)

data class CreateCustomerResponseModel(
    val id: String
)

interface CreateCustomer {
    fun create(requestModel: CreateCustomerRequestModel): CreateCustomerResponseModel
}