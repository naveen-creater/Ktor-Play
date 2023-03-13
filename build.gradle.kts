plugins {
    application
    kotlin("jvm") version "1.7.10"
}

group = "com.example"
version = "0.0.1"

application{
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-server-core:2.2.3")
    implementation("io.ktor:ktor-server-netty:2.2.3")
    implementation("ch.qos.logback:logback-classic:1.2.5")
}