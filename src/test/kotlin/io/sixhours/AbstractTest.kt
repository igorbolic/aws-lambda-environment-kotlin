package io.sixhours

import org.junit.BeforeClass

/**
 * Base class for test environment configuration.
 */
abstract class AbstractTest {
    companion object {
        @BeforeClass @JvmStatic fun setSystemProperty() {
            System.setProperty("LAMBDA_ENVIRONMENT", "test")
        }
    }
}
