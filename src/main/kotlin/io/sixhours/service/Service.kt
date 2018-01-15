package io.sixhours.service

import io.sixhours.conf.ConfigurationHolder

/**
 * Service object.
 */
interface Service {
    fun fullName(): String
}

object DefaultService : Service {

    private val config = ConfigurationHolder.configuration()

    override fun fullName(): String {
        val firstName = config?.user?.firstName
        val lastName = config?.user?.lastName

        return firstName + " " + lastName
    }
}
