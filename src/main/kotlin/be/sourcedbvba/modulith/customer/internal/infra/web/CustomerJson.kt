package be.sourcedbvba.modulith.customer.internal.infra.web

import org.jmolecules.ddd.types.Identifiable

data class CustomerJson(
    override val id: String,
    val name: String
) : Identifiable<String>
