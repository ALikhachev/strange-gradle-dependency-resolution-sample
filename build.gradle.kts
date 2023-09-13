plugins {
    java
    application
}

group = "org.example"

repositories {
    maven(buildDir.resolve("repo"))
    mavenCentral()
}

dependencies {
    implementation(project(":other-lib"))
    if (providers.gradleProperty("includeLib").orNull.toBoolean()) {
        implementation(project(":lib"))
    } else {
        implementation("org.example:lib:1.0.0-Beta2")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

application {
    mainClass.set("Main")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
    }
}

allprojects {
    version = providers.gradleProperty("myVersion").orElse("1.0-SNAPSHOT").get()
}