package selenium

import framework.selenium.createBlock
import frontend.core.Block
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebElement


inline fun <reified T> block(): T {
    return createBlock(T::class.java, { rootElement() }) as T
}

inline fun <reified T> block(locator: By): T {
    return createBlock(T::class.java, { getWebDriver().findElement(locator) }) as T
}

inline fun <reified T> block(noinline findElement: () -> WebElement): T {
    return createBlock(T::class.java, findElement) as T
}

inline fun <reified T> blocks(locator: By): () -> List<T> {
    return { getWebDriver().findElements(locator).map { createBlock(T::class.java, { it }) as T } }
}

inline fun <reified T> SearchContext.hasBlock(): T {
    return createBlock(T::class.java, this) as T
}

inline fun <reified T> SearchContext.hasBlock(locator: By): T {
    return createBlock(T::class.java, this, locator) as T
}

inline fun <reified T> SearchContext.hasBlocks(locator: By): () -> List<T> {
    return { this.findElements(locator).map { createBlock(T::class.java, { it }) as T } }
}

class BlockBuilder {
    var _locator: By? = null
    var _name: String? = null

    fun name(block: ()-> String) {
        _name = block()
    }

    fun found(block: ()-> By) {
        _locator = block()
    }
}

infix inline fun <reified T> SearchContext.hasBlock(init: BlockBuilder.()-> Unit): T {
    val blockBuilder = BlockBuilder()
    blockBuilder.init()
    if (blockBuilder._name == null) {
        blockBuilder._name = T::class.toString()
    }
    val block =
            if (blockBuilder._locator == null) {
                createBlock(T::class.java, this)
            }
            else {
                createBlock(T::class.java, this, blockBuilder._locator!!)
            }
    block.name(blockBuilder._name!!)
    return block as T
}

