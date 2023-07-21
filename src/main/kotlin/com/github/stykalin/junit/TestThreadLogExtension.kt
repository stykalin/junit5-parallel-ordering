package com.github.stykalin.junit

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtensionContext
import java.io.File
import java.time.LocalDateTime

/**
 * Collecting test execution ordering by threads.
 */
class TestThreadLogExtension : BeforeAllCallback, BeforeTestExecutionCallback {

    companion object {
        private const val TEST_STATS_DIR = "target/.logs"
        private const val TEST_BY_THREAD_PATH = "$TEST_STATS_DIR/testsByThread.txt"
    }

    override fun beforeAll(context: ExtensionContext) {
        File(TEST_STATS_DIR).mkdirs()
    }

    /** Collect info about test execution */
    override fun beforeTestExecution(context: ExtensionContext) {
        val testFqn = context.requiredTestMethod.let { it.declaringClass.name + "." + it.name }

        val testByThreadFile = File(TEST_BY_THREAD_PATH)
        if (!testByThreadFile.exists()) {
            testByThreadFile.createNewFile()
        }
        testByThreadFile.appendText("${LocalDateTime.now()} | Thread: ${Thread.currentThread().id} | FQN: $testFqn\n")
    }
}