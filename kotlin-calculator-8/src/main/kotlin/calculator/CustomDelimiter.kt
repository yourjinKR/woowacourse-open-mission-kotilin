package calculator


class CustomDelimiter(): Delimiter {
    override val defaultDelimiter: String
        get() = super.defaultDelimiter

    override lateinit var calcArea: String
    lateinit var customDelimiter: String

    constructor(rawData: String) : this() {
        val calcArea = rawData.substring(5, rawData.length)
        val customDelimiter = rawData[2]

        this.calcArea = calcArea
        this.customDelimiter = customDelimiter.toString()
    }

    override fun splitByDelimiter(): List<String> {
        val delimiter = customDelimiter + defaultDelimiter
        val delimiterRegex = "[${Regex.escape(delimiter)}]".toRegex()
        return calcArea.split(delimiterRegex)
    }
}


fun main() {
//    val string = "123456789"
//    println(string.substring(0,5))
//    println(string.substring(5, string.length))

//    println(string.substring(5))

    // 객체 생성 테스트
    val customDelimiter = CustomDelimiter("//?\\n1?2?3?4")
    val numList = customDelimiter.splitByDelimiter()
    val result = Calculator.sumStringList(numList)
    println(result)
}
