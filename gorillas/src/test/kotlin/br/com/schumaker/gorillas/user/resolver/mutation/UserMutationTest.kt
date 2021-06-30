package br.com.schumaker.gorillas.user.resolver.mutation

import br.com.schumaker.gorillas.user.exception.AuthenticationException
import br.com.schumaker.gorillas.user.model.repository.UserRepository
import br.com.schumaker.gorillas.user.service.UserService
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserMutationTest(
    @Autowired val service: UserService,
    @Autowired val repository: UserRepository,
    @Autowired val userMutation: UserMutation
) {
    @Test
    fun `'auth' try to authenticate with success`() {
        runBlocking {
            val authResponse = userMutation.auth("Missy Sippy", "xyaeqYbq")
            Assertions.assertNotEquals(null, authResponse)
            Assertions.assertNotEquals(null, authResponse.data)
            Assertions.assertTrue(authResponse.errors.isEmpty())

            val authString = authResponse.data
            Assertions.assertNotEquals(0, authString!!.length)
            Assertions.assertTrue(authString.contains('.'))
        }
    }

    @Test
    fun `'auth' try to authenticate and fail`() {
        runBlocking {
            val authResponse = userMutation.auth("Ken Masters", "W@ss3r")
            Assertions.assertNotEquals(null, authResponse)
            Assertions.assertNotEquals(null, authResponse.errors)
            Assertions.assertEquals(null, authResponse.data)
            Assertions.assertEquals(1, authResponse.errors.size)
            Assertions.assertTrue(authResponse.errors[0] is AuthenticationException)
        }
    }
}