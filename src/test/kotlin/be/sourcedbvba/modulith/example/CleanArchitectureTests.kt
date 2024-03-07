package be.sourcedbvba.modulith.example

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.library.Architectures
import org.jmolecules.architecture.hexagonal.SecondaryPort
import org.jmolecules.archunit.JMoleculesArchitectureRules
import org.junit.jupiter.api.Test

class CleanArchitectureTests {
    val importedClasses = ClassFileImporter().importPackages("be.sourcedbvba.modulith")

    @Test
    fun `check bounded contexts adhere to Clean Architecture rules`() {
        val architecture = Architectures.layeredArchitecture()
            .consideringOnlyDependenciesInLayers()

            .layer("domain").definedBy("..internal.domain..")
            .layer("application").definedBy("..internal.app..")
            .layer("data infrastructure").definedBy("..internal.infra.data..")
            .layer("web infrastructure").definedBy("..internal.infra.web..")

            .whereLayer("domain").mayNotAccessAnyLayer()
            .whereLayer("application").mayOnlyAccessLayers("domain")
            .whereLayer("data infrastructure").mayOnlyAccessLayers("domain")
            .whereLayer("web infrastructure").mayOnlyAccessLayers("application")
        architecture.check(importedClasses);
    }

    @Test
    fun `check bounded contexts adhere to hexagonal architecture rules`() {
        val architecture = JMoleculesArchitectureRules.ensureHexagonal()
        architecture.check(importedClasses);
    }
}