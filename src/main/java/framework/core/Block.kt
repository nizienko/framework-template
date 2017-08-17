package frontend.core

import allure.step
import framework.selenium.element
import org.openqa.selenium.*

/**
 * Created by nizienko on 27.07.2017.
 */
abstract class Block : WebElement {
    lateinit var blockRootElement: WebElement
    var name: String? = null

    infix fun found(locator: By) {
        blockRootElement = blockRootElement.element(locator)
    }

    infix fun name(name: String) {
        this.name = name
    }

    open fun lateInit() {}

    override fun isDisplayed(): Boolean = blockRootElement.isDisplayed
    override fun clear() = blockRootElement.clear()

    override fun submit() = blockRootElement.submit()

    override fun getLocation(): Point = blockRootElement.location

    override fun <X : Any?> getScreenshotAs(p0: OutputType<X>?): X = blockRootElement.getScreenshotAs(p0)

    override fun findElement(p0: By?): WebElement = blockRootElement.findElement(p0)

    override fun click() = step("Кликаем по '$name'") { blockRootElement.click() }

    override fun getTagName(): String = blockRootElement.tagName

    override fun getSize(): Dimension = blockRootElement.size

    override fun getText(): String = blockRootElement.text

    override fun isSelected(): Boolean = blockRootElement.isSelected

    override fun isEnabled(): Boolean = blockRootElement.isEnabled

    override fun sendKeys(vararg p0: CharSequence?) = blockRootElement.sendKeys(*p0)

    override fun getAttribute(p0: String?): String = blockRootElement.getAttribute(p0)

    override fun getRect(): Rectangle = blockRootElement.rect

    override fun getCssValue(p0: String?): String = blockRootElement.getCssValue(p0)

    override fun findElements(p0: By?): MutableList<WebElement> = blockRootElement.findElements(p0)
}