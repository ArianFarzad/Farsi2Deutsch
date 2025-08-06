plugins {
    kotlin("jvm") version "2.2.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-server-core:2.3.8")
    implementation("io.ktor:ktor-server-netty:2.3.8")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(22)
}

application {
    mainClass.set("org.example.MainKt")
}