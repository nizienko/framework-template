package example.contnent.yandex.blocks

import frontend.content.blocks.common.Element
import frontend.core.Block
import org.openqa.selenium.By
import selenium.byBem
import selenium.hasBlock

class SearchBlock : Block() {
    override fun lateInit() {
        this name "Блок поиска"
        this found byBem(
                block = "container",
                element = "search")
    }

    val searchField = this.hasBlock<Element> {
        name { "Строка поиска" }
        found { By.id("text") }
    }

    val searchButton = this.hasBlock<Element> {
        name { "Искать" }
        found { byBem(block = "suggest2-form", element = "button") }
    }
}