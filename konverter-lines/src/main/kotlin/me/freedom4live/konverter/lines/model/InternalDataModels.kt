package me.freedom4live.konverter.lines.model

internal data class StringNode(var storedValue: String?, val subNodes: MutableMap<String, StringNode>)

internal data class StringNodeTree(val root: StringNode) {

    fun addValueInTheEnd(paths: List<String>) {

    }

}