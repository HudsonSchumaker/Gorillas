package br.com.schumaker.gorillas.user.service

import br.com.schumaker.gorillas.user.model.entity.User
import br.com.schumaker.gorillas.user.model.repository.UserRepository
import kotlinx.coroutines.reactive.awaitFirstOrDefault

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserServiceImpl(private val repository: UserRepository): UserService {

    override fun findAll(): Flux<List<User>> {
        return repository.findAll().collectList().flux()
    }

    override fun findById(id: Long): Mono<User> {
        return repository.findById(id)
    }

    override fun authentication(userName: String, password: String): Mono<User> {
        return repository.findByUserNameAndPassword(userName, password)
    }
}