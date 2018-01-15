package io.sixhours.env

/**
 * Enum constant with available lambda environments.
 */
enum class Environment {
    test, dev, stage, prod;

    companion object {
        private val LAMBDA_ENVIRONMENT = "LAMBDA_ENVIRONMENT"

        /**
         * Returns [Environment] enum constant resolved from the lambda environment variable.
         */
        fun value(): Environment {
            val env = System.getenv(LAMBDA_ENVIRONMENT) ?: System.getProperty(LAMBDA_ENVIRONMENT)

            if (env != null) {
                return Environment.valueOf(env)
            }
            throw IllegalArgumentException("Invalid lambda environment")
        }
    }
}
