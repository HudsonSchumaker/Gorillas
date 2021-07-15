package br.com.schumaker.gorillas.user.model.entity

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import org.springframework.data.annotation.Id

/**
 * @author Hudson Schumaker
 */
@GraphQLDescription("User records")
data class User(
    @Id
    var id: Int?,
    val firstName: String,
    val lastName: String,
    val userName: String,

    @GraphQLIgnore
    val password: String,
    val email: String
)
