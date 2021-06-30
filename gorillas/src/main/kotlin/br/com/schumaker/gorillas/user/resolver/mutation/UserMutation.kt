package br.com.schumaker.gorillas.user.resolver.mutation

import br.com.schumaker.gorillas.user.exception.AuthenticationException
import br.com.schumaker.gorillas.user.model.entity.User
import br.com.schumaker.gorillas.user.service.UserService
import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.stereotype.Component
import graphql.execution.DataFetcherResult
import io.fusionauth.jwt.Signer
import io.fusionauth.jwt.domain.JWT
import io.fusionauth.jwt.hmac.HMACSigner
import kotlinx.coroutines.reactor.awaitSingle
import java.time.ZoneOffset
import java.time.ZonedDateTime

@Component
class UserMutation(private val service: UserService): Mutation {

    val signer: Signer = HMACSigner.newSHA256Signer("blowfish")

    suspend fun auth(userName : String, password : String): DataFetcherResult<String?> {

        try {
            val user = service.authentication(userName, password)
            return DataFetcherResult.newResult<String?>().data(generateToken(user.awaitSingle())).build()
        } catch (e: Exception) {
            return DataFetcherResult.newResult<String?>().error(AuthenticationException()).build()
        }
    }

    private fun generateToken(user : User): String {
        val jwt = JWT().setIssuer("www.godizilla.gz")
            .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
            .setSubject(user.userName)
            .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(120))

        return JWT.getEncoder().encode(jwt, signer)
    }
}
