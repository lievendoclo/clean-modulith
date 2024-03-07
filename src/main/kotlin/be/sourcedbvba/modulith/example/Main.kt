package be.sourcedbvba.modulith.example

import be.sourcedbvba.modulith.support.domain.event.SpringEventPublisher
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class ModulithApplication {
    @Bean
    open fun eventPublisher(applicationEventPublisher: ApplicationEventPublisher) = SpringEventPublisher(applicationEventPublisher)

}

fun main(vararg args: String) {
    SpringApplication.run(ModulithApplication::class.java, *args)
}