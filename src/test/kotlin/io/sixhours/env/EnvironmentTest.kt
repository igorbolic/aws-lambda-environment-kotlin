package io.sixhours.env

import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

/**
 * Environment variable tests.
 */
class EnvironmentTest {

    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    @Test fun whenEnvironmentVariableSetThenResolveToTestEnvironment() {
        System.setProperty("LAMBDA_ENVIRONMENT", "test")

        val environment = Environment.value()

        assertThat(environment).isEqualTo(Environment.test)
    }

    @Test fun whenEnvironmentVariableSetThenResolveToDevEnvironment() {
        System.setProperty("LAMBDA_ENVIRONMENT", "dev")

        val environment = Environment.value()

        assertThat(environment).isEqualTo(Environment.dev)
    }

    @Test fun whenEnvironmentVariableSetThenResolveToStageEnvironment() {
        System.setProperty("LAMBDA_ENVIRONMENT", "stage")

        val environment = Environment.value()

        assertThat(environment).isEqualTo(Environment.stage)
    }

    @Test fun whenEnvironmentVariableSetThenResolveToProdEnvironment() {
        System.setProperty("LAMBDA_ENVIRONMENT", "prod")

        val environment = Environment.value()

        assertThat(environment).isEqualTo(Environment.prod)
    }

    @Test fun whenEnvironmentVariableEmptyThenThrowException() {
        System.setProperty("LAMBDA_ENVIRONMENT", "")

        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("No enum constant io.sixhours.env.Environment.")

        Environment.value()
    }

    @Test fun whenEnvironmentVariableNullThenThrowException() {
        System.clearProperty("LAMBDA_ENVIRONMENT")

        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("Invalid lambda environment")

        Environment.value()
    }

    @Test fun whenEnvironmentVariableIllegalThenThrowException() {
        System.setProperty("LAMBDA_ENVIRONMENT", "illegal")

        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("No enum constant io.sixhours.env.Environment.illegal")

        Environment.value()
    }

}