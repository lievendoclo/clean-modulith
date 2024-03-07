package be.sourcedbvba.modulith.example.customer.internal.domain.event

import be.sourcedbvba.modulith.support.domain.event.Event

data class CustomerCreated(
    val id: String,
    val name: String,
    override val eventType: String = "CustomerCreated"
) : Event