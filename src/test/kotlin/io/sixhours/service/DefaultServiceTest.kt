package io.sixhours.service

import io.sixhours.AbstractTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Service tests.
 */
class DefaultServiceTest : AbstractTest() {

    private val service = DefaultService

    @Test fun whenAskedForFullNameThenReturnValue() {
        val result = service.fullName()

        assertThat(result).isNotNull()
        assertThat(result).isEqualTo("Kent Beck")
    }
}