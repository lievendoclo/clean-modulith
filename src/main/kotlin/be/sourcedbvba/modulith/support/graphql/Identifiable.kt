package be.sourcedbvba.modulith.support.graphql

/**
 * Marks a GraphQL type that has an `id` field with ID type
 */
interface Identifiable {
    val id: String
}