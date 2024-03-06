package be.sourcedbvba.modulith.order.internal.infra.web

import org.jmolecules.ddd.types.Identifiable

data class OrderJson(
    override val id: String
) : Identifiable<String>