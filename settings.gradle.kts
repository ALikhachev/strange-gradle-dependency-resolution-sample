rootProject.name = "gradle-strange-resolution"

include(":other-lib")

if (providers.gradleProperty("includeLib").orNull.toBoolean()) {
    include(":lib")
    project(":lib").projectDir = if (providers.gradleProperty("publish").orNull.toBoolean()) {
        rootDir.resolve("published-lib")
    } else {
        rootDir.resolve("local-lib")
    }
}