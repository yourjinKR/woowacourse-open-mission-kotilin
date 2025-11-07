package calculator
/*
    구분자는 일반 구분자와 커스텀 구분자가 있음
 */
interface Delimiter {
    val defaultDelimiter: String
        get() = ",:"
    val calcArea: String
    fun splitByDelimiter() : List<String>
}