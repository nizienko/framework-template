package frontend.content.blocks.common

import allure.step
import frontend.core.Block

/**
 * Created by nizienko on 27.07.2017.
 */
class TextField : Block() {
    fun fill(text: String) {
        step("Заполняем поле '$name' значением '$text'") {
            with(blockRootElement) {
                clear()
                sendKeys(text)
            }
        }
    }
}