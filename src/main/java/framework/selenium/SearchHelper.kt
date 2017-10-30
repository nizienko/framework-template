package framework.selenium

import org.openqa.selenium.*

/**
 * Created by nizienko on 04.10.2017.
 */

fun SearchContext.findVisibleElement(by: By): WebElement {
    val list = findElements(by).filter { it.isDisplayed }
    if (list.isEmpty()) {
        throw WebDriverException("Не смогли найти элемент $by")
    }
    try {
        return list.first()
    } catch (ignored: StaleElementReferenceException) {
    }
    return findElement(by)
}

fun wait(s: Int, waitFor: () -> Boolean): Boolean {
    val step = 100L
    val c = s * 10
    for (i in 1..c) {
        try {
            if (waitFor()) {
                break
            } else {
                Thread.sleep(step)
            }
        } catch (e: Exception) {
            Thread.sleep(step)
        }
    }
    return waitFor()
}

fun <O> attempt(n: Int, block: () -> O): O {
    var finalError: Throwable? = null
    for (i in 1..n) {
        try {
            return block()
        } catch (e: OutOfAttemptsException) {
            throw e
        } catch (e: Exception) {
            println(bar(i))
            finalError = e
            Thread.sleep(1000)
        }
    }
    if (finalError != null) {
        throw OutOfAttemptsException(finalError)
    } else throw OutOfAttemptsException(IllegalStateException("Не удалось выполнить действие"))
}

class OutOfAttemptsException(e: Throwable) : Exception(e)

private fun bar(n: Int): String {
    val bar = StringBuilder()
    for (i in 1..n) {
        bar.append(".")
    }
    return bar.toString()
}
