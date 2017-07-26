package example.contnent.yandex.blocks

import selenium.element
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext

class SerpListBlock(searchContext: SearchContext) {
    val thisBlock = element {
        searchContext.findElement(By.className("serp-list"))
    }

    val serpItems = {
        thisBlock.findElements(By.className("serp-item")).map { SerpItem(it) }
    }
}