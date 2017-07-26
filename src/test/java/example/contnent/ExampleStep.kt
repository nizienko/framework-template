package example.contnent

import example.contnent.yandex.YandexPage
import framework.container.di

class ExampleStep {
    val yandexPage: YandexPage by di()

    fun printHelloWorld() {
        println("Hello world")
    }
}