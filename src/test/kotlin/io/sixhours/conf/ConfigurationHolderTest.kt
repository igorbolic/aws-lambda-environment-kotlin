package io.sixhours.conf

import io.sixhours.AbstractTest
import org.assertj.core.api.Assertions
import org.junit.Test

/**
 * Configuration holder tests.
 */
class ConfigurationHolderTest : AbstractTest() {

    @Test fun whenEnvironmentInitializedThenConfigurationValuesAreLoaded() {
        val configuration = ConfigurationHolder.configuration()

        Assertions.assertThat(configuration).isNotNull()
        Assertions.assertThat(configuration!!.user).isNotNull()
        Assertions.assertThat(configuration.user.firstName).isEqualTo("Kent")
        Assertions.assertThat(configuration.user.lastName).isEqualTo("Beck")
    }

}