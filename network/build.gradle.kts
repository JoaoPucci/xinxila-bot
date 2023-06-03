plugins {
    kotlin("jvm") version "1.8.21"
}

group = "tech.pucci"
version = "1.0.0"

val ktor_version: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    
    implementation("io.insert-koin:koin-core:3.4.0")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}