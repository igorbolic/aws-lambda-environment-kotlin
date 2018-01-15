package io.sixhours

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import io.sixhours.service.DefaultService
import io.sixhours.service.Service

/**
 * AWS Lambda function.
 */
class LambdaFunction : RequestHandler<String, String> {

    private val service: Service = DefaultService

    override fun handleRequest(input: String, context: Context): String = service.fullName()
}
