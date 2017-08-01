package io.sixhours

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * Lambda handler tests.

 * @author Igor Bolic
 */
class LambdaFunctionTest : AbstractTest() {

    private val input = ""
    private val context = TestContext()

    @Test fun thatHandleRequestReturnsResult() {
        val handler = LambdaFunction()

        val result = handler.handleRequest(input, context)

        assertThat(result, notNullValue())
        assertThat(result, `is`("Kent Beck"))
    }

}