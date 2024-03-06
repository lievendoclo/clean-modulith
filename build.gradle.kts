plugins {
    kotlin("jvm") version "1.9.22"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.springframework.boot") version "3.2.3"
}

group = "be.sourcedbvba"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:1.1.3")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("com.apollographql.federation:federation-graphql-java-support:4.4.1")
    implementation("org.jmolecules:kmolecules-ddd:1.9.0")
    implementation("org.jmolecules:jmolecules-hexagonal-architecture:1.9.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.tngtech.archunit:archunit:1.2.1")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    testImplementation("org.jmolecules.integrations:jmolecules-archunit:0.19.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}