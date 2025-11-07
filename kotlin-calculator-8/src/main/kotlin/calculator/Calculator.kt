package calculator

class Calculator {
    companion object {
        fun sumStringList(strList: List<String>): Int {
            return strList.sumOf { it.toInt() }
        }
    }
}