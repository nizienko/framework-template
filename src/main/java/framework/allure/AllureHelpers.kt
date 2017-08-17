package allure

import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertTrue
import org.openqa.selenium.WebElement
import ru.yandex.qatools.allure.annotations.Step

/**
 * Created by nizienko on 03.08.2017.
 */

@Step("{1}")
fun step(title: String, block: () -> Unit) {
    println(title)
    block()
}

fun checkThat(description: String, whatCheck: ()->Boolean){
    step(description) {
        tryDo(5) {
            assertThat(description, whatCheck())
        }
    }
}

fun tryDo(times: Int, whatDo: ()-> Unit) {
    for (i in 1..times) {
        try {
            whatDo()
            break
        }
        catch (e: Exception){
            Thread.sleep(1000)
        }
    }
}