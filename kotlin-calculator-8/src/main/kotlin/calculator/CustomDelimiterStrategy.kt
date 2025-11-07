package calculator

class CustomDelimiterStrategy(): DelimiterStrategy {
    val defaultDelimiter = ",:"
    val headerRegex = "^//.\\\\n.*".toRegex()

    override fun isSupport(rawData: String): Boolean {
        return rawData.matches(headerRegex)
    }

    override fun getCalcArea(rawData: String):List<String> {
        val customDelimiter = rawData[2]
        val calcArea = rawData.substring(5, rawData.length)

        val delimiter = customDelimiter + defaultDelimiter
        val delimiterRegex = "[${Regex.escape(delimiter)}]".toRegex()
        return calcArea.split(delimiterRegex)
    }
}