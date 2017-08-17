package example.contnent.yandex.blocks

import frontend.core.Block
import selenium.byBem
import selenium.hasBlocks

class SerpListBlock : Block() {
    override fun lateInit() {
        this found byBem("serp-list")
    }

    val serpItems = this.hasBlocks<SerpItem>(byBem("serp-item"))
}