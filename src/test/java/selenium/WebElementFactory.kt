package selenium

import framework.proxy.Proxy
import net.sf.cglib.proxy.Enhancer
import org.openqa.selenium.WebElement

fun element(findElement: () -> WebElement): WebElement {
    return Enhancer.create(WebElement::class.java, Proxy(findElement)) as WebElement
}