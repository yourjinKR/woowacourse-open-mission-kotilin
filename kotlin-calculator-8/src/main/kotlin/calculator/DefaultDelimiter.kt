package calculator

class DefaultDelimiter(override val calcArea: String) : Delimiter {
    override val defaultDelimiter: String
        get() = super.defaultDelimiter

    override fun splitByDelimiter(): List<String> {
        val delimiterRegex = "[${Regex.escape(defaultDelimiter)}]".toRegex()
        return calcArea.split(delimiterRegex)
    }
}

fun main() {
    val delimiter = DefaultDelimiter("1,2,3,5")
    val calcArea = delimiter.splitByDelimiter();

    val result = Calculator.sumStringList(calcArea)
    println(result)
}
