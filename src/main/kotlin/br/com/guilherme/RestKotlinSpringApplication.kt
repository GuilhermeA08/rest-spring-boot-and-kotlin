package br.com.guilherme

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestKotlinSpringApplication

fun main(args: Array<String>) {
	runApplication<RestKotlinSpringApplication>(*args)
}
