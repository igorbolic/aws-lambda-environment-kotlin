package io.sixhours.env

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

/**
 * Environment variable tests.
 *
 * @author Igor Bolic
 */
class EnvironmentTest {

    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    @Test fun thatResolvingEnvironmentFromEnvironmentVariableReturnsTestEnvironment() {
        System.setProperty("LAMBDA_ENVIRONMENT", "test")

        val environment = Environment.value()

        assertThat(environment, `is`(Environment.test))
    }

    @Test fun thatResolvingEnvironmentFromEnvironmentVariableReturnsDevEnvironment() {
        System.setProperty("LAMBDA_ENVIRONMENT", "dev")

        val environment = Environment.value()

        assertThat(environment, `is`(Environment.dev))
    }

    @Test fun thatResolvingEnvironmentFromEnvironmentVariableReturnsStageEnvironment() {
        System.setProperty("LAMBDA_ENVIRONMENT", "stage")

        val environment = Environment.value()

        assertThat(environment, `is`(Environment.stage))
    }

    @Test fun thatResolvingEnvironmentFromEnvironmentVariableReturnsProdEnvironment() {
        System.setProperty("LAMBDA_ENVIRONMENT", "prod")

        val environment = Environment.value()

        assertThat(environment, `is`(Environment.prod))
    }

    @Test fun thatResolvingEnvironmentFromEmptyEnvironmentVariableThrowsException() {
        System.setProperty("LAMBDA_ENVIRONMENT", "")

        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("No enum constant io.sixhours.env.Environment.")

        Environment.value()
    }

    @Test fun thatResolvingEnvironmentFromNullEnvironmentVariableThrowsException() {
        System.clearProperty("LAMBDA_ENVIRONMENT")

        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("Invalid lambda environment")

        Environment.value()
    }

    @Test fun thatResolvingEnvironmentFromIllegalEnvironmentVariableThrowsException() {
        System.setProperty("LAMBDA_ENVIRONMENT", "illegal")

        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("No enum constant io.sixhours.env.Environment.illegal")

        Environment.value()
    }

}