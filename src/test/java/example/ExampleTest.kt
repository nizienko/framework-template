package example

import allure.checkThat
import example.contnent.ExampleStep
import example.contnent.yandex.SerpPage
import example.contnent.yandex.YandexPage
import framework.container.di
import org.junit.Test


class ExampleTest : Suite() {
    val exampleSteps: ExampleStep by di()

    val yandexPage: YandexPage by di()
    val serpPage: SerpPage by di()

    @Test
    fun searchTest() {
        with(yandexPage) {
            open()
            with(searchBlock) {
                searchField.fill("Kotlin")
                searchButton.click()
            }
        }
        serpPage.resultBlock.serpItems()
                .forEach {
                    checkThat("${it.name} содержит kotlin в content") {
                        it.content.text.toLowerCase().contains("kotlin")
                    }
                }
    }

    @Test
    fun helloWorld() {
        exampleSteps.printHelloWorld()
    }
}