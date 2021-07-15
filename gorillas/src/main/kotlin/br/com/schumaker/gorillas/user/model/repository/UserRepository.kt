package br.com.schumaker.gorillas.user.model.repository

import br.com.schumaker.gorillas.user.model.entity.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

/**
 * @author Hudson Schumaker
 */
@Repository
interface UserRepository : ReactiveCrudRepository<User, Long> {

    fun findByUserNameAndPassword(userName: String, password: String): Mono<User>
}
