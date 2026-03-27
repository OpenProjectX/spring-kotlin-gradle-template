# Spring Kotlin Gradle Template

A [Cookiecutter](https://cookiecutter.readthedocs.io/) template for creating multi-module Spring Boot starters in Kotlin with Gradle, ready for publication to Maven Central.

## Using this template on GitHub

There are two ways to use this template:

### Option A — Cookiecutter (recommended)

Cookiecutter fills in all variables for you interactively.

**1. Install Cookiecutter (once)**

```bash
pipx install cookiecutter   # Debian/Ubuntu
# or: brew install cookiecutter
# or: pip install cookiecutter
```

**2. Generate a new project**

```bash
# From GitHub (replace with your username/org):
cookiecutter gh:openprojectx/spring-kotlin-gradle-template

# Pin to a specific release:
cookiecutter gh:openprojectx/spring-kotlin-gradle-template --checkout v1.0.0

# From a local clone:
cookiecutter path/to/spring-kotlin-gradle-template
```

Cookiecutter prompts for each variable, then generates a ready-to-use project in a new directory.

### Option B — GitHub "Use this template" button

Click **Use this template → Create a new repository** on the GitHub page.
This copies the repo as-is (including the `{{cookiecutter.*}}` placeholders).
You must then manually find-and-replace the placeholder values:

| Placeholder | Replace with |
|---|---|
| `{{cookiecutter.project_slug}}` | your project directory name |
| `{{cookiecutter.group_id}}` | your Maven group ID |
| `{{cookiecutter.library_name}}` | your library short name |
| `{{cookiecutter.main_class_name}}` | your main class prefix |
| `{{cookiecutter.github_username}}` | your GitHub username/org |
| _(all others in `cookiecutter.json`)_ | your values |

Also rename the `{{cookiecutter.project_slug}}/` directory itself, and the files inside `autoconfigure/` and `starter/` that contain `{{cookiecutter.library_name}}` in their names.

**Option A is strongly recommended** — manual substitution is error-prone.

## Making this repo a GitHub Template Repository

To enable the "Use this template" button:

1. Go to **Settings** of this repository on GitHub
2. Under **General**, check **Template repository**
3. Save

Once enabled, visitors see a green **Use this template** button at the top of the repo page.

## Versioning and releases

Tag releases so users can pin to a stable version:

```bash
git tag v1.0.0
git push origin v1.0.0
```

Users can then use:

```bash
cookiecutter gh:openprojectx/spring-kotlin-gradle-template --checkout v1.0.0
```

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