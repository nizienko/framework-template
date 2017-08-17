package framework.selenium

import frontend.core.Block
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import selenium.rootElement

fun createBlock(kClass: Class<*>, searchContext: SearchContext): Block {
    when (searchContext) {
        is WebElement -> return createBlock(kClass, searchContext)
        is WebDriver -> return createBlock(kClass, rootElement())
        else -> throw IllegalStateException("Unknown searchContext")
    }
}

fun createBlock(kClass: Class<*>, searchContext: SearchContext, locator: By): Block {
    return createBlock(kClass, { searchContext.findElement(locator) })
}

fun createBlock(kClass: Class<*>, findElement: () -> WebElement): Block {
    return createBlock(kClass, element(findElement))
}

fun createBlock(kClass: Class<*>, element: WebElement): Block {
    if (kClass.superclass != Block::class.java) {
        throw IllegalStateException("Can't create block")
    }
    val block = kClass.newInstance() as Block
    block.blockRootElement = element
    block.lateInit()
    return block
}