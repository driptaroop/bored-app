package org.dripto.boredapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class BoredAppApplication {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.rootUri("http://www.boredapi.com/api/").build()
}

fun main(args: Array<String>) {
    runApplication<BoredAppApplication>(*args)
}
