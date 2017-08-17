package selenium

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

fun createWebDriver(): WebDriver {
    if (System.getProperty("webdriver.chrome.driver") == null) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-3")
    }
    return ChromeDriver()
}