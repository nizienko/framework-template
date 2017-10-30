package example.contnent.yandex

import example.contnent.yandex.blocks.SearchBlock
import example.contnent.yandex.blocks.SerpListBlock
import selenium.block


class SerpPage {
    val searhBlock = block<SearchBlock>()
    val resultBlock = block<SerpListBlock>()
}