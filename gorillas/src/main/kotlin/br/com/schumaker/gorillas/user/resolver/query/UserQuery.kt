package br.com.schumaker.gorillas.user.resolver.query

import br.com.schumaker.gorillas.user.model.entity.User
import br.com.schumaker.gorillas.user.service.UserService
import com.expediagroup.graphql.server.operations.Query
import kotlinx.coroutines.reactive.awaitFirstOrDefault
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Component

/**
 * @author Hudson Schumaker
 */
@Component
class UserQuery(private val service: UserService): Query {

    suspend fun users(): List<User> {
        return service.findAll().awaitFirstOrDefault(listOf())
    }

    suspend fun user(id: Long): User? {
        return service.findById(id).awaitSingle()
    }
}
