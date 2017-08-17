package selenium

import framework.selenium.element
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import kotlin.concurrent.getOrSet

val webDrivers = ThreadLocal<WebDriver>()

fun getWebDriver(): WebDriver {
    return webDrivers.getOrSet {
        createWebDriver()
    }
}

fun rootElement(): WebElement {
    return element { getWebDriver().findElement(By.xpath("/*")) }
}

fun closeWebDriver() {
    getWebDriver().quit()
    webDrivers.remove()
}