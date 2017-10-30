package selenium

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

/**
 * Created by nizienko on 31.07.2017.
 */

fun byText(text: String): By = By.xpath(".//*[text()='$text']")

fun classContains(className: String): String = "[contains(concat(' ', @class, ' '), ' $className ')]"

fun rootElement(): WebElement = getWebDriver().findElement(By.xpath("/*"))

fun byBem(block: String, element: String = "", modifiers: Map<String, String> = emptyMap(), hasText: String = ""): By {
    val xpath = StringBuilder()
    val name = if (element.isNotEmpty()) {
        "${block}__$element"
    } else {
        block
    }

    xpath.append(".//*${classContains(name)}")
    modifiers.forEach { k, v ->
        xpath.append(classContains("${name}_${k}_${v}"))
    }

    if (hasText.isNotEmpty()) {
        xpath.append("[.//*[contains(text(), '$hasText')]]")
    }
    return By.xpath(xpath.toString())
}
