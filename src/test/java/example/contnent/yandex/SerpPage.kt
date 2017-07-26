package example.contnent.yandex

import example.contnent.yandex.blocks.SearchBlock
import example.contnent.yandex.blocks.SerpListBlock
import selenium.getWebDriver

class SerpPage {
    val searchBlock = SearchBlock(getWebDriver())
    val serpListBlock = SerpListBlock(getWebDriver())
}