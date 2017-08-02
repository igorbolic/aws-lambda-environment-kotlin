package io.sixhours.env

import java.util.Optional

/**
 * Enum constant with available lambda environments.

 * @author Igor Bolic
 */
enum class Environment {
    test, dev, stage, prod;

    companion object {
        private val LAMBDA_ENVIRONMENT = "LAMBDA_ENVIRONMENT"

        /**
         * Returns [Environment] enum constant resolved from the lambda environment variable.
         */
        fun value(): Environment {
            val env = Optional.ofNullable(System.getenv(LAMBDA_ENVIRONMENT))
                    .orElse(System.getProperty(LAMBDA_ENVIRONMENT))

            if (env != null) {
                return Environment.valueOf(env)
            }
            throw IllegalArgumentException("Invalid lambda environment")
        }
    }
}
