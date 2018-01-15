package io.sixhours

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Lambda handler tests.
 */
class LambdaFunctionTest : AbstractTest() {

    private val input = ""
    private val context = TestContext()

    @Test fun whenAskedToHandleRequestThenReturnResult() {
        val handler = LambdaFunction()

        val result = handler.handleRequest(input, context)

        assertThat(result).isNotNull()
        assertThat(result).isEqualTo("Kent Beck")
    }

}