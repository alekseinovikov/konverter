package me.freedom4live.konverter.lines.impl

import me.freedom4live.konverter.lines.LinesKonverterType
import me.freedom4live.konverter.lines.TypedLinesParser
import me.freedom4live.konverter.lines.model.StringNodeTree

internal class PropertiesTypedLinesParser : TypedLinesParser {

    override fun supportingType() = LinesKonverterType.PROPERTIES

    override fun parse(lines: List<String>): StringNodeTree {
        TODO()
    }

    private fun convertLine(line: String, root: StringNodeTree) {
        TODO()
    }
}