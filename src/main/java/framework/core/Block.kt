package frontend.core

import allure.step
import framework.selenium.attempt
import framework.selenium.findVisibleElement
import org.openqa.selenium.*

/**
 * Created by nizienko on 27.07.2017.
 */
abstract class Block : WebElement {
    lateinit var blockRootElement: () -> WebElement
    var name: String? = null

    infix fun found(locator: By) {
        val innerBlockRootElement = blockRootElement
        blockRootElement = { innerBlockRootElement().findVisibleElement(locator) }
    }

    infix fun name(name: String) {
        this.name = name
    }

    fun getThisElement(): WebElement {
        return attempt(10) { blockRootElement() }
    }

    open fun lateInit() {}

    override fun isDisplayed(): Boolean = blockRootElement().isDisplayed
    override fun clear() = getThisElement().clear()

    override fun submit() = getThisElement().submit()

    override fun getLocation(): Point = getThisElement().location

    override fun <X : Any?> getScreenshotAs(p0: OutputType<X>?): X = getThisElement().getScreenshotAs(p0)

    override fun findElement(p0: By?): WebElement = getThisElement().findElement(p0)

    override fun click() = step("Кликаем по '$name'") { getThisElement().click() }

    override fun getTagName(): String = getThisElement().tagName

    override fun getSize(): Dimension = getThisElement().size

    override fun getText(): String = getThisElement().text

    override fun isSelected(): Boolean = getThisElement().isSelected

    override fun isEnabled(): Boolean = getThisElement().isEnabled

    override fun sendKeys(vararg p0: CharSequence?) = getThisElement().sendKeys(*p0)

    override fun getAttribute(p0: String?): String = getThisElement().getAttribute(p0)

    override fun getRect(): Rectangle = getThisElement().rect

    override fun getCssValue(p0: String?): String = getThisElement().getCssValue(p0)

    override fun findElements(p0: By?): MutableList<WebElement> = getThisElement().findElements(p0)

    fun isExist(): Boolean {
        try {
            return blockRootElement().isDisplayed
        } catch (e: Exception) {
            return false
        }
    }
}