# frameworktemplate
Quick start of test automation with kotlin

1. Block: construct your blocks using other blocks.
Please see the example:
    https://github.com/nizienko/framework-template/blob/master/src/test/java/example/contnent/yandex/blocks/SearchBlock.kt
    Overriding lateinit fun you can specify name(for allure report) and locator of current block. It is useful when this block could be found by the locator always.
    If in different situations the same block could be found by different locators you can describe locator when you put the block into another block or page.
To specify block inside another block:
    `this.hasBlock<%BLOCK_TYPE%>{name {"%BLOCK_NAME%"} found {%LOCATOR%}}` - this block will be searched in current block context.
To specify block inside page:
`block<%BLOCK_TYPE%>{name {"%BLOCK_NAME%"} found {%LOCATOR%}}`
If blocks 'name' and 'found' already described in it lateinit function, you can just simple use `this.hasBlock<%BLOCK_TYPE%>()` or `block<%BLOCK_TYPE%>()`

2. Page: just specify blocks and functions for page:
    https://github.com/nizienko/framework-template/blob/master/src/test/java/example/contnent/yandex/YandexPage.kt

3. Step: this layer is useful to avoid copy-pasting when you write the same code in different tests.

4. Test: when your page objects are ready - create tests


