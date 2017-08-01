package io.sixhours.conf

import io.sixhours.env.Environment
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.InputStream
import java.util.stream.Collectors
import java.util.stream.StreamSupport

/**
 * Holds a configuration loaded from the `application.yml` file on the classpath.

 * @author Igor Bolic
 */
object ConfigurationHolder {
    private val yaml = Yaml(Constructor(Configuration::class.java))
    private var configuration: Map<Environment, Configuration> = mapOf()

    init {
        load()
    }

    private fun load() {
        val inputStream = ConfigurationHolder::class.java.getResourceAsStream("/application.yml")
        val iterable = yaml.loadAll(inputStream)

        configuration = iterable.asSequence()
                .map { it as Configuration }
                .associateBy { it.environment }
    }

    fun configuration(): Configuration? {
        return this.configuration[Environment.value()]
    }
}
