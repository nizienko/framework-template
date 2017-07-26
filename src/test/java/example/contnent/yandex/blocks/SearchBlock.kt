package example.contnent.yandex.blocks

import selenium.element
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext

class SearchBlock(val parentBlock: SearchContext) {
    val thisBlock = element {
        parentBlock.findElement(By.className("container__search"))
    }

    val searchField = element {
        thisBlock.findElement(By.id("text"))
    }

    val searchButton = element {
        thisBlock.findElement(By.className("suggest2-form__button"))
    }
}