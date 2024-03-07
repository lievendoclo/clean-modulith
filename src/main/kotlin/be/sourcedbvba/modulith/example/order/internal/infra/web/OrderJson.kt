package be.sourcedbvba.modulith.example.order.internal.infra.web

import be.sourcedbvba.modulith.support.graphql.Identifiable

data class OrderJson(
    override val id: String
) : Identifiable