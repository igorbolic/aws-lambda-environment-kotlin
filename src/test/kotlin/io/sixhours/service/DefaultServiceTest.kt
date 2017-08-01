package io.sixhours.service

import io.sixhours.AbstractTest
import org.junit.Test

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat

/**
 * Service tests.

 * @author Igor Bolic
 */
class DefaultServiceTest : AbstractTest() {

    private val service = DefaultService

    @Test fun thatAddReturnsCorrectResult() {
        val result = service.fullName()

        assertThat(result, notNullValue())
        assertThat(result, `is`("Kent Beck"))
    }
}