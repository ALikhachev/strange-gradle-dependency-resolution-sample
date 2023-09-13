plugins {
    `java-library`
}

group = "org.example"

repositories {
    maven(rootProject.buildDir.resolve("repo"))
    mavenCentral()
}

dependencies {
    api("org.example:lib:1.0.0-Beta1")
}