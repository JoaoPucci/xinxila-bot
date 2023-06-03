plugins {
    kotlin("jvm") version "1.8.21"
}

group = "tech.pucci"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}