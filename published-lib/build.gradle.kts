plugins {
    java
    `maven-publish`
}

group = "org.example"

repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven(rootProject.buildDir.resolve("repo"))
    }
    publications {
        create<MavenPublication>("lib") {
            groupId = "org.example"
            artifactId = "lib"
            from(components["java"])
        }
    }
}

tasks.processResources.configure {
    inputs.property("version", version)
    filesMatching("version.properties") {
        expand("version" to version)
    }
}
