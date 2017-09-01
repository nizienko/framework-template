package framework.selenium

import frontend.core.Block
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import selenium.getWebDriver
import selenium.rootElement

fun createBlock(kClass: Class<*>, searchContext: SearchContext): Block {
    return when (searchContext) {
        is WebElement -> createBlock(kClass, searchContext)
        is WebDriver -> createBlock(kClass, { rootElement() })
        else -> throw IllegalStateException("Unknown searchContext")
    }
}

fun createBlock(kClass: Class<*>, searchContext: SearchContext, locator: By): Block {
    return createBlock(kClass, { searchContext.findElement(locator) })
}


fun createBlock(kClass: Class<*>, findElement: () -> WebElement): Block {
    if (kClass.superclass != Block::class.java) {
        throw IllegalStateException("Can't create block")
    }
    val block = kClass.newInstance() as Block
    block.blockRootElement = findElement
    block.lateInit()
    return block
}