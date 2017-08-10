package io.sixhours.conf

import io.sixhours.env.Environment
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

/**
 * Holds a configuration loaded from the `application.yml` file on the classpath.

 * @author Igor Bolic
 */
object ConfigurationHolder {
    private val yaml = Yaml(Constructor(Configuration::class.java))
    private val configuration: Map<Environment, Configuration> by lazy { load() }

    private fun load(): Map<Environment, Configuration> {
        val inputStream = ConfigurationHolder::class.java.getResourceAsStream("/application.yml")
        val iterable = yaml.loadAll(inputStream)

        return iterable.asSequence()
                .map { it as Configuration }
                .associateBy { it.environment }
    }

    fun configuration(): Configuration? = configuration[Environment.value()]
}
