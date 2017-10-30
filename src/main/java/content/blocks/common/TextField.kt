package content.blocks.common

import allure.step
import frontend.core.Block

class TextField : Block() {
    fun fill(text: String) {
        step("Заполняем поле $name значением $text") {
            clear()
            sendKeys(text)
        }
    }
}