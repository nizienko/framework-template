package example.contnent.yandex

import example.contnent.yandex.blocks.SearchBlock
import example.contnent.yandex.blocks.SerpListBlock
import selenium.block


class SerpPage {
    val searchBlock = block<SearchBlock>()
    val serpListBlock = block<SerpListBlock>()

}