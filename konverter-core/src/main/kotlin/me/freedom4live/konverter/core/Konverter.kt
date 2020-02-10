package me.freedom4live.konverter.core

interface Konverter {
    fun convert(bytes: ByteArray): ByteArray
}

interface StringsKonverter : Konverter {
    fun convert(lines: List<String>): List<String>

    override fun convert(bytes: ByteArray): ByteArray = convert(String(bytes).split(LINE_SEPARATOR))
        .joinToString(LINE_SEPARATOR).toByteArray()
}
