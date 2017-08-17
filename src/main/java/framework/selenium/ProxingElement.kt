package framework.selenium

import framework.proxy.Proxy
import net.sf.cglib.proxy.Enhancer
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebElement

fun element(findElement: () -> WebElement): WebElement {
    return Enhancer.create(WebElement::class.java, Proxy(findElement)) as WebElement
}

fun SearchContext.element(locator: By): WebElement {
    return Enhancer.create(WebElement::class.java, Proxy({ this.findElement(locator) })) as WebElement
}