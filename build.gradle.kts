plugins {
    kotlin("jvm") version "1.8.21"
}

group = "tech.pucci"
version = "1.0.0"

repositories {
    mavenCentral()
}

val ktor_version: String by project

dependencies {
    implementation("dev.kord:kord-core:0.9.0")
    implementation("io.insert-koin:koin-core:3.4.0")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}