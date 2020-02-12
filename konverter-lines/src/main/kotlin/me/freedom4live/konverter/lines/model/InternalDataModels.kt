package me.freedom4live.konverter.lines.model

internal data class StringNode(var storedValue: String?, val subNodes: MutableMap<String, StringNode>)

internal class StringNodeTree {

    private val emptyListArgumentException = IllegalArgumentException("paths list must not be null!")

    private val root: StringNode = StringNode(null, mutableMapOf())

    fun addValueByPath(path: List<String>, value: String) = addToTrie(path.notEmpty(), value)
    fun findValueByPath(path: List<String>): String? = findInSubNodes(path.notEmpty())


    private fun addToTrie(path: List<String>, value: String) {
        var currentNode = root
        path.forEach {
            currentNode = getOrCreateSubNodeBySubPath(currentNode, it)
        }

        currentNode.storedValue = value
    }

    private fun getOrCreateSubNodeBySubPath(node: StringNode, subPath: String) =
        findSubNodeBySubPath(node, subPath) ?: createSubNodeByPath(node, subPath)

    private fun createSubNodeByPath(node: StringNode, subPath: String) =
        StringNode(null, mutableMapOf()).also { node.subNodes[subPath] = it }

    private fun findSubNodeBySubPath(node: StringNode, subPath: String) = node.subNodes[subPath]

    private fun findInSubNodes(path: List<String>): String? {
        var currentNode = root
        path.forEach {
            currentNode = findSubNodeBySubPath(currentNode, it) ?: return null
        }

        return currentNode.storedValue
    }

    private fun <T : Any> List<T>.notEmpty() = if (this.isNotEmpty()) this else throw emptyListArgumentException

}