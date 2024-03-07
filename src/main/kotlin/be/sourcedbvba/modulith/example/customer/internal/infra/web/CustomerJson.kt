package be.sourcedbvba.modulith.example.customer.internal.infra.web

import be.sourcedbvba.modulith.support.graphql.Identifiable

data class CustomerJson(
    override val id: String,
    val name: String
) : Identifiable
