package frontend.core

import org.junit.AfterClass
import selenium.closeWebDriver

/**
 * Created by nizienko on 27.07.2017.
 */
open class UiSuite {
    companion object {
        @JvmStatic
        @AfterClass
        fun closeDriver() {
            closeWebDriver()
        }
    }
}