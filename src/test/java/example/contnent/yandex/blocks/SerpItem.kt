package example.contnent.yandex.blocks

import frontend.content.blocks.common.Element
import frontend.core.Block
import selenium.byBem
import selenium.hasBlock

class SerpItem : Block() {
    override fun lateInit() {
        this name "Элемент результата"
        title name "Заголовок"
        content name "Контент"
    }
    val title = this.hasBlock<Element>(byBem(block = "organic", element = "title-wrapper"))
    val subTitle = this.hasBlock<Element>(byBem(block = "organic", element = "subtitle"))
    val content = this.hasBlock<Element>(byBem(block = "organic", element = "content-wrapper"))
}