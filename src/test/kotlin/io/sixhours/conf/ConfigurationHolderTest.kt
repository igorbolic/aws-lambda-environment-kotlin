package io.sixhours.conf

import io.sixhours.AbstractTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * Configuration holder tests.
 *
 * @author Igor Bolic
 */
class ConfigurationHolderTest : AbstractTest() {

    @Test fun thatConfigurationValuesAreLoaded() {
        val configuration = ConfigurationHolder.configuration()

        assertThat(configuration, notNullValue())
        assertThat(configuration!!.user, notNullValue())
        assertThat(configuration.user.firstName, `is`("Kent"))
        assertThat(configuration.user.lastName, `is`("Beck"))
    }

}