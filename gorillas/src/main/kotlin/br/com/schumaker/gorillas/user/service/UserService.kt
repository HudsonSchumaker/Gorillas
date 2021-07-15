package br.com.schumaker.gorillas.user.service

import br.com.schumaker.gorillas.user.model.entity.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author Hudson Schumaker
 */
interface UserService {

    fun findAll(): Flux<List<User>>
    fun findById(id: Long): Mono<User>
    fun authentication(userName: String, password: String): Mono<User>
}
