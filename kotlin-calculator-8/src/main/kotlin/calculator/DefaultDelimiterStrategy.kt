package calculator

class DefaultDelimiterStrategy(): DelimiterStrategy {
    val defaultDelimiter = ",:"

    override fun isSupport(rawData: String): Boolean {
        return rawData.matches("^[0-9${defaultDelimiter}]*$".toRegex())
    }

    override fun getCalcArea(rawData: String): List<String> {
        return rawData.split("[${Regex.escape(defaultDelimiter)}]".toRegex())
    }
}

fun main() {
    val input = "1,2,3,4,5"
    val del = DefaultDelimiterStrategy()

    println(del.isSupport(input))
}