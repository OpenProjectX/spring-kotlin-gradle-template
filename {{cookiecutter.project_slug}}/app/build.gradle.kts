plugins {
    id("buildsrc.convention.kotlin-jvm")
    id("buildsrc.convention.spring-kotlin")
    id("com.google.cloud.tools.jib") version "3.5.4"
}


dependencies {
    implementation(project(":{{ cookiecutter.project_slug }}-spring-boot-starter"))
}

jib {
    from {
        image = "eclipse-temurin:{{ cookiecutter.java_version }}-jre"
    }
    to {
        image = providers.gradleProperty("jibToImage")
            .orElse(providers.environmentVariable("JIB_TO_IMAGE"))
            .orElse("ghcr.io/{{ cookiecutter.github_username.lower() }}/{{ cookiecutter.github_repo }}")
            .get()
        tags = setOf(project.version.toString())

        val username = providers.gradleProperty("jibToUsername")
            .orElse(providers.environmentVariable("JIB_TO_USERNAME"))
            .orNull
        val password = providers.gradleProperty("jibToPassword")
            .orElse(providers.environmentVariable("JIB_TO_PASSWORD"))
            .orNull

        if (!username.isNullOrBlank() && !password.isNullOrBlank()) {
            auth {
                this.username = username
                this.password = password
            }
        }
    }
    container {
        mainClass = "{{ cookiecutter.group_id }}.app.{{ cookiecutter.main_class_name }}ApplicationKt"
        ports = listOf("8080")
        labels = mapOf(
            "org.opencontainers.image.title" to "{{ cookiecutter.project_name }}",
            "org.opencontainers.image.description" to "{{ cookiecutter.description }}",
            "org.opencontainers.image.source" to "https://github.com/{{ cookiecutter.github_username }}/{{ cookiecutter.github_repo }}",
            "org.opencontainers.image.version" to project.version.toString(),
            "org.opencontainers.image.licenses" to "Apache-2.0",
        )
    }
}
