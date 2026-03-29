plugins {
    id("buildsrc.convention.kotlin-jvm")
    id("buildsrc.convention.spring-kotlin")
}


dependencies {

    implementation(project(":{{ cookiecutter.project_slug }}-spring-boot-starter"))

}