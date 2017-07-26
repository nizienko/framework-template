package example

import selenium.closeWebDriver
import org.junit.AfterClass

open class Suite {
    companion object {
        @JvmStatic
        @AfterClass
        fun closeDriver() {
            closeWebDriver()
        }
    }
}