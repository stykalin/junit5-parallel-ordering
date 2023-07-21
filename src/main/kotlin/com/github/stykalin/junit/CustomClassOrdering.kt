package com.github.stykalin.junit

import org.junit.jupiter.api.ClassDescriptor
import org.junit.jupiter.api.ClassOrderer
import org.junit.jupiter.api.ClassOrdererContext
import org.junit.jupiter.api.Order
import java.io.File

class CustomClassOrdering : ClassOrderer {

    override fun orderClasses(context: ClassOrdererContext) {
        File(TEST_STATS_DIR).mkdirs()
        val testSortingBefore = File(TEST_SORTING_BEFORE_PATH)
        val testSortingAfter = File(TEST_SORTING_AFTER_PATH)
        testSortingBefore.createNewFile()
        testSortingAfter.createNewFile()

        testSortingBefore.writeText(context.classDescriptors.joinToString("\n"))
        context.classDescriptors.sortWith(Comparator.comparingInt(Companion::getOrder))
        testSortingAfter.writeText(context.classDescriptors.joinToString("\n"))
    }

    companion object {

        private fun getOrder(descriptor: ClassDescriptor): Int {
            return descriptor.findAnnotation(Order::class.java).map(Order::value).orElse(Order.DEFAULT)
        }

        private const val TEST_STATS_DIR = "target/.logs"
        private const val TEST_SORTING_BEFORE_PATH = "$TEST_STATS_DIR/testSorting_before.txt"
        private const val TEST_SORTING_AFTER_PATH = "$TEST_STATS_DIR/testSorting_after.txt"
    }
}