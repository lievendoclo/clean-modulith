package be.sourcedbvba.modulith.customer.internal.domain.event

import org.jmolecules.event.annotation.DomainEvent

@DomainEvent
data class CustomerCreated(
    val id: String,
    val name: String
)
