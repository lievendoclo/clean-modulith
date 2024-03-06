package be.sourcedbvba.modulith

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.library.Architectures
import org.junit.jupiter.api.Test

class CleanArchitectureTests {
    val importedClasses = ClassFileImporter().importPackages("be.sourcedbvba.modulith")
    val safeDependencies = arrayOf( "kotlin..", "java..", "javax..", "org.jetbrains.annotations..")

    @Test
    fun `check bounded contexts adhere to Clean Architecture rules`() {
        val architecture = Architectures.layeredArchitecture()
            .consideringOnlyDependenciesInLayers()

            .layer("domain").definedBy("..internal.domain..")
            .layer("application API").definedBy("..internal.app.api..")
            .layer("application").definedBy("..internal.app.impl..")
            .layer("data infrastructure").definedBy("..internal.infra.data..")
            .layer("web infrastructure").definedBy("..internal.infra.web..")

            .whereLayer("domain").mayNotAccessAnyLayer()
            .whereLayer("application API").mayNotAccessAnyLayer()
            .whereLayer("application").mayOnlyAccessLayers("domain", "application API")
            .whereLayer("data infrastructure").mayOnlyAccessLayers("domain")
            .whereLayer("web infrastructure").mayOnlyAccessLayers("application API")
        architecture.check(importedClasses);
    }

    @Test
    fun `application API layer should have only defined dependencies`() {
        classes().that().resideInAPackage("..internal.app.api..")
            .should().onlyDependOnClassesThat()
            .resideInAnyPackage(
                "..internal.app.api..",
                *safeDependencies)
            .check(importedClasses)
    }

    @Test
    fun `domain layer should have only defined dependencies`() {
        classes().that().resideInAPackage("..internal.domain..")
            .should().onlyDependOnClassesThat()
            .resideInAnyPackage(
                "..internal.domain..",
                *safeDependencies)
            .check(importedClasses)
    }
}