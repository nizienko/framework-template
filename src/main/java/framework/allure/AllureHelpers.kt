package allure

import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import ru.yandex.qatools.allure.annotations.Step

/**
 * Created by nizienko on 03.08.2017.
 */

@Step("{1}")
fun <O> step(title: String, block: () -> O): O {
    println(title)
    return block()
}

@Step("{1}")
fun step(title: String, block: () -> Unit) {
    println(title)
    block()
}

fun checkThat(description: String, whatCheck: () -> Boolean) {
    step("Проверяем, что $description") {
        assertThat(description, whatCheck())
    }
}

fun <O> checkThat(description: String, o: O, matcher: Matcher<O>) {
    step("Проверяем, что $description") {
        assertThat(description, o, matcher)
    }
}

