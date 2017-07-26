package example

import example.contnent.yandex.SerpPage
import example.contnent.yandex.YandexPage
import framework.container.di
import org.junit.Test
import kotlin.test.assertTrue


class ExampleTest : Suite() {
    val yandexPage: YandexPage by di()
    val serpPage: SerpPage by di()

    @Test fun searchTest() {
        with(yandexPage) {
            open()
            with(searchBlock) {
                searchField.sendKeys("Kotlin")
                searchButton.click()
            }
        }
        serpPage
                .serpListBlock
                    .serpItems()
                    .forEach {
                        println(it.title.text)
                        assertTrue { it.content.text.toLowerCase().contains("kotlin") }
                    }

    }
}