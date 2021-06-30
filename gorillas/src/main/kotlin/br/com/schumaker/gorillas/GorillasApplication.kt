package br.com.schumaker.gorillas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GorillasApplication

fun main(args: Array<String>) {
	runApplication<GorillasApplication>(*args)
}
