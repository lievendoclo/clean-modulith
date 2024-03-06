package be.sourcedbvba.modulith

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ModulithApplication {

}
fun main(vararg args: String) {
    SpringApplication.run(ModulithApplication::class.java, *args)
}