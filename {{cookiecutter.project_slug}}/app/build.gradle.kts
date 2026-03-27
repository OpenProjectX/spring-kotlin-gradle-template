plugins {
    id("buildsrc.convention.kotlin-jvm")
    id("buildsrc.convention.spring-kotlin")
}


dependencies {

    implementation(project(":{{ cookiecutter.library_name }}-spring-boot-starter"))

}