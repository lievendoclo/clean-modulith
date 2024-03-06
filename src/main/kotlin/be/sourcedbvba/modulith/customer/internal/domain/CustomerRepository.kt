package be.sourcedbvba.modulith.customer.internal.domain

interface CustomerRepository {
    fun findCustomers(): List<Customer>
}