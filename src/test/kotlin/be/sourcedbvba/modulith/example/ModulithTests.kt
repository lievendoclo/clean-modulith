package be.sourcedbvba.modulith.example

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules

class ModulithTests {
    @Test
    fun checkModulithBoundedContextRules() {
        ApplicationModules.of(ModulithApplication::class.java).verify()
    }

    @Test
    fun writeDocumentationSnippets() {
        val modules = ApplicationModules.of(ModulithApplication::class.java)
        modules.forEach { println(it) }
    }
}