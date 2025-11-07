package calculator


class ParseUtil {
    companion object {
        fun parseToIntList(list: List<String>): List<Int> {
            try {
                return list.map { str -> str.toInt() }
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("올바른 값을 입력해주세요")
            }
        }
    }
}