package selenium

import org.openqa.selenium.WebDriver
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