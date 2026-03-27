plugins {
    kotlin("jvm")
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of({{ cookiecutter.java_version }})) }
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:${libs.versions.springBoot.get()}"))

    api(project(":{{ cookiecutter.library_name }}-spring-boot-autoconfigure"))
}