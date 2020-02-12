package me.freedom4live.konverter.lines.model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull

internal class StringNodeTreeTest {

    @Test
    @DisplayName("add value to path, path must not be empty")
    fun pathIsEmptyValueShouldThrowException() {
        val tree = StringNodeTree()

        assertFailsWith<IllegalArgumentException> { tree.addValueByPath(listOf(), "value") }
    }

    @Test
    @DisplayName("add value to path, works ok")
    fun pathIsNotEmptyAddingWorks() {
        val tree = StringNodeTree()
        val simplePath = listOf("node1.node2")

        tree.addValueByPath(simplePath, "value")
    }

    @Test
    @DisplayName("when tree is empty, any path is not found")
    fun whenTreeIsEmptyAnyNodeIsNotFound() {
        val tree = StringNodeTree()
        val anyPath = listOf("node1.node2")

        val result = tree.findValueByPath(anyPath)

        assertNull(result)
    }

    @Test
    @DisplayName("finding by empty path throws illegal argument exception")
    fun findValueByEmptyPathIllegalArgumentException() {
        val tree = StringNodeTree()
        val path = emptyList<String>()

        assertFailsWith<IllegalArgumentException> { tree.findValueByPath(path) }
    }

    @Test
    @DisplayName("added value must be found by the same path")
    fun addedValuesMustBeFoundByTheSamePath() {
        val tree = StringNodeTree()
        val path = listOf("node1", "node2")
        val value = "value"

        tree.addValueByPath(path, value)
        val result = tree.findValueByPath(path)

        assertNotNull(result)
        assertEquals(value, result)
    }

}