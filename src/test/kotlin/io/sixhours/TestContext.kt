package io.sixhours

import com.amazonaws.services.lambda.runtime.ClientContext
import com.amazonaws.services.lambda.runtime.CognitoIdentity
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger

/**
 * A simple mock implementation of the `Context` interface. Default
 * values are stubbed out, and setters are provided so you can customize
 * the context before passing it to your function.
 */
class TestContext : Context {

    private var awsRequestId = "EXAMPLE"
    private var clientContext: ClientContext? = null
    private var functionName = "EXAMPLE"
    private var identity: CognitoIdentity? = null
    private var logGroupName = "EXAMPLE"
    private var logStreamName = "EXAMPLE"
    private var logger: LambdaLogger = TestLambdaLogger()
    private var memoryLimitInMB = 128
    private var remainingTimeInMillis = 15000
    private var functionVersion = "EXAMPLE"
    private var invokedFunctionArn = "arn:aws:lambda:us-west-2:123456789012:function:aws-lambda-jdbc-java:test"

    override fun getAwsRequestId(): String {
        return awsRequestId
    }

    fun setAwsRequestId(value: String) {
        awsRequestId = value
    }

    override fun getClientContext(): ClientContext? {
        return clientContext
    }

    fun setClientContext(value: ClientContext) {
        clientContext = value
    }

    override fun getFunctionName(): String {
        return functionName
    }

    fun setFunctionName(value: String) {
        functionName = value
    }

    override fun getIdentity(): CognitoIdentity? {
        return identity
    }

    fun setIdentity(value: CognitoIdentity) {
        identity = value
    }

    override fun getLogGroupName(): String {
        return logGroupName
    }

    fun setLogGroupName(value: String) {
        logGroupName = value
    }

    override fun getLogStreamName(): String {
        return logStreamName
    }

    fun setLogStreamName(value: String) {
        logStreamName = value
    }

    override fun getLogger(): LambdaLogger {
        return logger
    }

    fun setLogger(value: LambdaLogger) {
        logger = value
    }

    override fun getMemoryLimitInMB(): Int {
        return memoryLimitInMB
    }

    fun setMemoryLimitInMB(value: Int) {
        memoryLimitInMB = value
    }

    override fun getRemainingTimeInMillis(): Int {
        return remainingTimeInMillis
    }

    fun setRemainingTimeInMillis(value: Int) {
        remainingTimeInMillis = value
    }

    override fun getFunctionVersion(): String {
        return functionVersion
    }

    fun setFunctionVersion(value: String) {
        functionVersion = value
    }

    override fun getInvokedFunctionArn(): String {
        return invokedFunctionArn
    }

    fun setInvokedFunctionArn(value: String) {
        invokedFunctionArn = value
    }

    /**
     * `LambdaLogger` logging a string to stdout.
     */
    private class TestLambdaLogger : LambdaLogger {

        override fun log(message: String) {
            println(message)
        }
    }
}
