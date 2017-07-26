package example.contnent.yandex

import example.contnent.yandex.blocks.SearchBlock
import selenium.getWebDriver

class YandexPage {

    val searchBlock = SearchBlock(getWebDriver())

    fun open(): YandexPage {
        getWebDriver().get("https://yandex.ru")
        return this
    }

    fun getTitle(): String {
        return getWebDriver().title
    }
}