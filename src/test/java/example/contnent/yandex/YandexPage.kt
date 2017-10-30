package example.contnent.yandex

import example.contnent.yandex.blocks.SearchBlock
import selenium.block
import selenium.getWebDriver

class YandexPage {
    val searchBlock = block<SearchBlock>()

    fun open(): YandexPage {
        getWebDriver().get("https://yandex.ru")
        return this
    }

    fun getTitle(): String {
        return getWebDriver().title
    }
}