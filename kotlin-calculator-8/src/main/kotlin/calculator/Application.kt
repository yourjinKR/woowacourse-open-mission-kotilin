package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
//    val input = Console.readLine()
    val input = "//;\\n1;2,3"
    var delimiter = ",:"
    println(input)

    // 커스텀 구분자 있는지 확인
    val isCustom = hasCustomDelimiter(input)

    // 커스텀 구분자에 구분자 목록 등록
    if (isCustom) {
        val customDelimiter = getCustomDelimiter(input)
        delimiter += customDelimiter // String + char 조합이 가능
    }

    // 구분자로 문자열 나눔
    val numList = splitByDelimiters(input, delimiter)

    val total = sumStringList(numList)
    println(total)
}

// 커스텀 구분자 있는지 확인
fun hasCustomDelimiter(input: String): Boolean {
    val regex = "^//.\\\\n.*".toRegex()
    return input.matches(regex)
}

// 커스텀 구분자 리턴
fun getCustomDelimiter(input: String): Char {
    val header = input.take(5)
    val customDelimiter = header[2]
    return customDelimiter
}

// 구분자로 문자열 나눔
fun splitByDelimiters(input: String, delimiter: String): List<String> {
    val delimiterRegex = "[${Regex.escape(delimiter)}]".toRegex()
    val numList = input.substring(5).split(delimiterRegex)
    return numList;
}

// 문자열의 합을 계산
fun sumStringList(rawList: List<String>): Int {
    return rawList.sumOf { it.toInt() }
}