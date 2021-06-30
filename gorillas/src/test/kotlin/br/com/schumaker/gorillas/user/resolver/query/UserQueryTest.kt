package br.com.schumaker.gorillas.user.resolver.query

import br.com.schumaker.gorillas.user.model.repository.UserRepository
import br.com.schumaker.gorillas.user.service.UserService
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserQueryTest(
    @Autowired val service: UserService,
    @Autowired val repository: UserRepository,
    @Autowired val userQuery: UserQuery
) {

    @Test
    fun `'user' list all users`() {
        runBlocking<Unit> {
            val result = userQuery.users()
            Assertions.assertNotEquals(null, result)
            Assertions.assertNotNull(result.find {it.userName == "Brock Lee" && it.password == "dvfUErtM" })
            Assertions.assertNotNull(result.find {it.userName == "Evan Lee Arps" && it.password == "yyOyZxyf" })
        }
    }
}