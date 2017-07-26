package example

import example.contnent.ExampleStep
import framework.container.di
import org.junit.Test

class InjectionTest {
    val exampleStep : ExampleStep by di()

    @Test fun helloWorld() {
        exampleStep.printHelloWorld()
    }
}