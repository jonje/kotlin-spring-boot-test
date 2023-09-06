package org.haknet.kotlin.kotlinspringboottest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBootTestApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootTestApplication>(*args)
}
