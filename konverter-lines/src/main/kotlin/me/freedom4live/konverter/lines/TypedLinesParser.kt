package me.freedom4live.konverter.lines

import me.freedom4live.konverter.lines.model.StringNodeTree

internal interface TypedLinesParser {
    fun supportingType(): LinesKonverterType
    fun parse(lines: List<String>): StringNodeTree
}