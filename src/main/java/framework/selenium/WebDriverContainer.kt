package selenium

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

fun closeWebDriver() {
    getWebDriver().quit()
    webDrivers.remove()
}