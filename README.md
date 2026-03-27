# Spring Kotlin Gradle Template

A [Cookiecutter](https://cookiecutter.readthedocs.io/) template for creating multi-module Spring Boot starters in Kotlin with Gradle, ready for publication to Maven Central.

## Generated project structure

```
<project_slug>/
├── app/                          # Example Spring Boot application
├── core/                         # Core library module
├── autoconfigure/                # Spring Boot autoconfiguration module
│   └── <library_name>-spring-boot-autoconfigure.gradle.kts
├── starter/                      # Spring Boot starter (user-facing dependency)
│   └── <library_name>-spring-boot-starter.gradle.kts
├── buildSrc/                     # Gradle convention plugins
│   └── src/main/kotlin/
│       ├── kotlin-jvm.gradle.kts
│       └── spring-kotlin.gradle.kts
├── gradle/
│   └── libs.versions.toml        # Centralized dependency versions
├── build.gradle.kts              # Maven Central publishing + GPG signing
├── settings.gradle.kts           # Auto-discovers subprojects
└── gradle.properties
```

## Requirements

- Python 3.8+
- [Cookiecutter](https://cookiecutter.readthedocs.io/en/stable/README.html#installation)

```bash
pip install cookiecutter
```

## Usage

```bash
cookiecutter gh:openprojectx/spring-kotlin-gradle-template
```

Or from a local clone:

```bash
cookiecutter path/to/spring-kotlin-gradle-template
```

## Template variables

| Variable              | Default                | Description                                    |
|-----------------------|------------------------|------------------------------------------------|
| `project_name`        | My Spring Boot Starter | Human-readable project name                    |
| `project_slug`        | _(derived)_            | Directory name (lowercase, hyphenated)         |
| `group_id`            | org.example            | Maven group ID                                 |
| `library_name`        | mylib                  | Short name used in module names and packages   |
| `main_class_name`     | MyLib                  | Prefix for the Spring Boot main class          |
| `description`         | A Spring Boot starter  | Project description (used in POM)              |
| `github_username`     | username               | GitHub username/org (used in SCM URLs)         |
| `github_repo`         | _(derived)_            | GitHub repository name                         |
| `developer_id`        | username               | Developer ID in POM                            |
| `developer_name`      | Your Name              | Developer name in POM                          |
| `developer_email`     | your@email.com         | Developer email in POM                         |
| `kotlin_version`      | 2.2.21                 | Kotlin version                                 |
| `spring_boot_version` | 4.0.5                  | Spring Boot version                            |
| `java_version`        | 17                     | Java toolchain version                         |

## Publishing to Maven Central

Set environment variables and run:

```bash
export OSSRH_USERNAME=...
export OSSRH_PASSWORD=...
export SIGNING_KEY_FILE=path/to/key.gpg
export SIGNING_KEY_PASSWORD=...

./gradlew release
```

## Tech stack

- Kotlin 2.2.21
- Spring Boot 4.0.5
- Gradle 9.4.1 with configuration cache
- Java 17 toolchain