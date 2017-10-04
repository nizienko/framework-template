package example.contnent

import allure.step
import example.contnent.yandex.YandexPage
import framework.container.di

class ExampleStep {
    val yandexPage: YandexPage by di()

    fun printHelloWorld() {
        step("Написать hello world") {
            println("Hello world")
        }
    }
}