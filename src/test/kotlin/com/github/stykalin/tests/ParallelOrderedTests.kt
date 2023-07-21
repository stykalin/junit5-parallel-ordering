package com.github.stykalin.tests

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.lang.Thread.sleep

@Tag("P_TEST") annotation class P_TEST


fun testStep(name: String) {
    println("test $name. Thread: ${Thread.currentThread().id}")
    sleep(1_000)
}

@Order(5)
@P_TEST
class ATests {

    @Test
    fun testA_1() {
        testStep("testA_1")
    }

    @Test
    fun testA_2() {
        testStep("testA_2")
    }

    @Test
    fun testA_3() {
        testStep("testA_3")
    }

}

@Order(4)
@P_TEST
class BTests {
    @Test
    fun testB_1() {
        testStep("testB_1")
    }

    @Test
    fun testB_2() {
        testStep("testB_2")
    }

    @Test
    fun testB_3() {
        testStep("testB_3")
    }
}

@Order(3)
@P_TEST
class CTests {
    @Test
    fun testC_1() {
        testStep("testC_1")
    }

    @Test
    fun testC_2() {
        testStep("testC_2")
    }

    @Test
    fun testC_3() {
        testStep("testC_3")
    }
}

@Order(3)
@P_TEST
class DTests {
    @Test
    fun testD_1() {
        testStep("testD_1")
    }

    @Test
    fun testD_2() {
        testStep("testD_2")
    }

    @Test
    fun testD_3() {
        testStep("testD_3")
    }
}

@Order(2)
@P_TEST
class ETests {
    @Test
    fun testE_1() {
        testStep("testE_1")
    }

    @Test
    fun testE_2() {
        testStep("testE_2")
    }

    @Test
    fun testE_3() {
        testStep("testE_3")
    }
}

@Order(1)
@P_TEST
class FTests {
    @Test
    fun testF_1() {
        testStep("testF_1")
    }

    @Test
    fun testF_2() {
        testStep("testF_2")
    }

    @Test
    fun testF_3() {
        testStep("testF_3")
    }
}