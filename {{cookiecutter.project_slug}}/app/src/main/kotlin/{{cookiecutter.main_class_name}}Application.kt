package {{ cookiecutter.group_id }}.{{ cookiecutter.library_name }}.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class {{ cookiecutter.main_class_name }}Application

fun main(args: Array<String>) {

    runApplication<{{ cookiecutter.main_class_name }}Application>(*args)
}