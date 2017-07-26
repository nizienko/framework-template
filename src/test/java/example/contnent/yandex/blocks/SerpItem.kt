package example.contnent.yandex.blocks

import selenium.element
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext

class SerpItem(thisBlock: SearchContext) {
    val title = element {
        thisBlock.findElement(By.className("organic__title-wrapper"))
    }
    val subTitle = element {
        thisBlock.findElement(By.className("organic__subtitle"))
    }
    val content = element {
        thisBlock.findElement(By.className("organic__content-wrapper"))
    }
}