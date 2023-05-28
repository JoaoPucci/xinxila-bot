plugins {
    kotlin("jvm") version "1.8.21"
}

group = "tech.pucci"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":command"))

    implementation("io.insert-koin:koin-core:3.4.0")
    implementation("dev.kord:kord-core:0.9.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}