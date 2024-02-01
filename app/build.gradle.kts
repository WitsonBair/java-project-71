plugins {
    jacoco
    application
    checkstyle
    distribution
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.47.0"
}

application {mainClass.set("hexlet.code.App")}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}